package br.univali.portugol.nucleo.execucao.erros.mensagens;

import br.univali.portugol.nucleo.mensagens.ErroExecucao;

/**
 *
 * @author fillipi
 */
public class ErroDivisaoPorZero extends ErroExecucao
{
	private static final long serialVersionUID = 1L;

	@Override
	protected String construirMensagem()
	{
		return "Foi efetuada uma divisão por zero.";
	}
}
