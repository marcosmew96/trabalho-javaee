package br.univel.gerenciador.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.univel.gerenciador.Empresa;
import br.univel.gerenciador.dao.EmpresaDAO;

@WebServlet(urlPatterns = "/novaEmpresa")
public class NovaEmpresa extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException {

	    String nome = req.getParameter("nome");

	    Empresa empresa = new Empresa(nome);
	    new EmpresaDAO().adiciona(empresa);
	    
	    System.out.println("Empresa adicionada : " + nome);

	    req.setAttribute("nome", nome);

	    RequestDispatcher dispatcher = req
	            .getRequestDispatcher("/WEB-INF/paginas/novaEmpresa.jsp");
	    dispatcher.forward(req, resp);
	}
}
