<html>
<head>
</head>
<body>
Bem vindo ao nosso gerenciador de empresas!<br/>

<div>
	<form action="novaEmpresa" method="post">
    	Nome: <input type="text" name="nome" />
   		<input type = "submit" value = "Adicionar">
	</form>	
</div>
		
	<form action="busca" method="get">
    	Nome empresa: <input type="text" name="filtro" />
    	<input type="submit" value="Buscar" />
	</form>
	
</body>
</html>