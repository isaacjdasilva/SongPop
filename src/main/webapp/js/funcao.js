/*! Funções da tela de batalha */

$(document).ready(function() {
	$("#opcao1")
		.mouseover(function() { 
			$("#opcao1").css("border-color","red");
		})
		.mouseout(function() {
			$("#opcao1").css("border-color","white");
		});
	$("#opcao2")
		.mouseover(function() { 
			$("#opcao2").css("border-color","red");
		})
		.mouseout(function() {
			$("#opcao2").css("border-color","white");
		});
	$("#opcao3")
		.mouseover(function() { 
			$("#opcao3").css("border-color","red");
		})
		.mouseout(function() {
			$("#opcao3").css("border-color","white");
		});
	$("#opcao4")
		.mouseover(function() { 
			$("#opcao4").css("border-color","red");
		})
		.mouseout(function() {
			$("#opcao4").css("border-color","white");
		});
});