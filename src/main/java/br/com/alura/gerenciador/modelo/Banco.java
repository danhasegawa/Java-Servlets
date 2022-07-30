package br.com.alura.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {

	private static List<Empresa> lista = new ArrayList<>();
	private static List<Usuario> listaUsuarios= new ArrayList<>();
	private static Integer chaveSequencial = 1;

	static {
		Empresa empresa = new Empresa();
		empresa.setNome("Cozy Kitchen");
		empresa.setId(chaveSequencial++);

		Empresa empresa2 = new Empresa();
		empresa2.setNome("Google");
		empresa2.setId(chaveSequencial++);

		Empresa empresa3 = new Empresa();
		empresa3.setId(chaveSequencial++);
		empresa3.setNome("Section One");

		Banco.lista.add(empresa);
		Banco.lista.add(empresa2);
		Banco.lista.add(empresa3);

		Usuario u1 = new Usuario();
		u1.setLogin("dan");
		u1.setSenha("1234");
		Usuario u2 = new Usuario();
		u2.setLogin("ryan");
		u2.setSenha("1234");

		listaUsuarios.add(u2);
		listaUsuarios.add(u1);
	}

	public void adiciona(Empresa empresa) {
		empresa.setId(Banco.chaveSequencial++);
		Banco.lista.add(empresa);
		System.out.println("adicionnando nova empresa no banco de dados.");

	}

	public List<Empresa> getEmpresas() {
		return Banco.lista;
	}

	public void removeEmpresa(Integer id) {

		Iterator<Empresa> it = lista.iterator();

		while (it.hasNext()) {
			Empresa emp = it.next();

			if (emp.getId() == id) {
				it.remove();
			}
		}

	}

	public Empresa buscaEmpresaPelaId(Integer id) {

		for (Empresa empresa : lista) {
			if (empresa.getId() == id) {
				return empresa;
			}
		}
		return null;
	}

	public Usuario existeUsuario(String login, String senha) {
		for (Usuario usuario : listaUsuarios) {
			if (usuario.ehIgual(login, senha)) {
				return usuario;
			}
		}
		return null;
	}

}
