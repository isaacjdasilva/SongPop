package br.com.projeto.service;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import br.com.projeto.util.ApplicationProperties;

@Service
public class SendMailService {
	
	
//	@Autowired
	private JavaMailSender mailSender;
	
//	@Autowired
	private VelocityEngine velocity;
	
	public void sendContact(String name, String email, String ddd, String phone, String comment) {
		Map<String, Object> context = new HashMap<String, Object>();
		context.put("name", name);
		context.put("email", email);
		context.put("ddd", ddd);
		context.put("phone", phone);
		context.put("comment", comment);
		
		SimpleMailMessage msg = new SimpleMailMessage();  

		sendHtmlMail(msg, "email_contato.vm", context);
		
	}
	

	
	@SuppressWarnings("unchecked")
	public void sendHtmlMail(final SimpleMailMessage message, String templateName, Map context) {
		
		try {
			StringWriter writer = new StringWriter();
			context.put("siteUrl", ApplicationProperties.get(ApplicationProperties.SITE_URL));
			velocity.mergeTemplate(templateName, new VelocityContext(context), writer);
			final String body = writer.toString();
			
			MimeMessagePreparator preparator = new MimeMessagePreparator() {  
				public void prepare(MimeMessage mimeMessage) throws Exception {  
					MimeMessageHelper mime = new MimeMessageHelper(mimeMessage, "UTF-8");
					mime.setSubject(message.getSubject());  
					mime.setFrom(message.getFrom() != null ?  message.getFrom() : ApplicationProperties.get(ApplicationProperties.DEFAULT_MAIL_FROM));
					
					if (message.getReplyTo() != null)
						mime.setReplyTo(message.getReplyTo());
					
					for (int i = 0; i < message.getTo().length; i++) {
						mime.addTo(message.getTo()[i]);
					}
					for (int i = 0; message.getCc() != null && i < message.getCc().length; i++) {
						mime.addCc(message.getCc()[i]);
					}
					for (int i = 0; message.getBcc() != null && i < message.getBcc().length; i++) {
						mime.addCc(message.getBcc()[i]);
					}
					
					mime.setText(body, true);  
				}  
			};
	
			mailSender.send(preparator);
		
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

}
