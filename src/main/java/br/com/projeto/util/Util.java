/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/**
 * 
 * @author Isaac, Waldir
 */
public final class Util {

	private Util() {
	}

	public static boolean isNullOrEmpty(String valor) {
		if (valor == null || valor.trim().isEmpty()) {
			return true;
		}

		return false;
	}

	@SuppressWarnings("unchecked")
	public static boolean isNullOrVazio(Collection colecao) {
		if (colecao == null || colecao.isEmpty()) {
			return true;
		}

		return false;
	}

	@SuppressWarnings("unchecked")
	public static LinkedList<Integer> gerarNumerosAleatoriosComIntervalo(
			int quantidadeDeNumeros, int valorMaximo) {
		LinkedList<Integer> lista = new LinkedList();

		while (lista.size() != quantidadeDeNumeros) {
			Integer numeroGerado = (int) (Math.random() * valorMaximo);

			if (!lista.contains(numeroGerado)) {
				lista.add(numeroGerado);
			}
		}

		return lista;
	}

	public static int gerarNumerosAleatorios(int valorMaximo) {
		return (int) (Math.random() * (valorMaximo)) + 1;
	}

	@SuppressWarnings("unchecked")
	public static Collection removerNullColecao(Collection colecao) {

		if (!isNullOrVazio(colecao)) {

			Iterator interator = colecao.iterator();

			while (interator.hasNext()) {
				Object object = interator.next();

				if (object instanceof String) {
					if (object == null) {
						interator.remove();
					} else if (Util.isNullOrEmpty((String) object)) {
						interator.remove();
					}
				}

			}
		}

		return colecao;
	}
	
	public static String getQueryClauses(final Map<String, Object> params,
			final Map<String, Object> orderParams) {
		final StringBuffer queryString = new StringBuffer();
		if ((params != null) && !params.isEmpty()) {
			queryString.append(" where ");
			for (final Iterator<Map.Entry<String, Object>> it = params
					.entrySet().iterator(); it.hasNext();) {
				final Map.Entry<String, Object> entry = it.next();
				if (entry.getValue() instanceof Boolean) {
					queryString.append(entry.getKey()).append(" is ")
							.append(entry.getValue()).append(" ");
				} else {
					if (entry.getValue() instanceof Number) {
						queryString.append(entry.getKey()).append(" = ")
								.append(entry.getValue());
					} else {
						// string equality
						queryString.append(entry.getKey()).append(" = '")
								.append(entry.getValue()).append("'");
					}
				}
				if (it.hasNext()) {
					queryString.append(" and ");
				}
			}
		}
		if ((orderParams != null) && !orderParams.isEmpty()) {
			queryString.append(" order by ");
			for (final Iterator<Map.Entry<String, Object>> it = orderParams
					.entrySet().iterator(); it.hasNext();) {
				final Map.Entry<String, Object> entry = it.next();
				queryString.append(entry.getKey()).append(" ");
				if (entry.getValue() != null) {
					queryString.append(entry.getValue());
				}
				if (it.hasNext()) {
					queryString.append(", ");
				}
			}
		}
		return queryString.toString();
	}
	
}