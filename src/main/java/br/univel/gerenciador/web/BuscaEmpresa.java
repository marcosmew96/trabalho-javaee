package br.univel.gerenciador.web;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.univel.gerenciador.Empresa;
import br.univel.gerenciador.dao.EmpresaDAO;

@WebServlet(urlPatterns = "/busca")
public class BuscaEmpresa extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException {

	    String filtro = req.getParameter("filtro");
	    Collection<Empresa> empresas = new EmpresaDAO()
	            .buscaPorSimilaridade(filtro);
	    
	    System.out.println("Empresa buscada : " + filtro);

	    req.setAttribute("empresas", empresas);

	    RequestDispatcher dispatcher = req
	            .getRequestDispatcher("/WEB-INF/paginas/buscaEmpresa.jsp");
	    dispatcher.forward(req, resp);
	   

	}
}