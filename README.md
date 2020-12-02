# spotcrack

Spotcrack é uma api que trabalha com o controle de musicas e cantores usando java como linguagem e mysql como banco de dados 


Ferramenta utilizadas 
-- java --
Maeve
Hibernate (utilizamos o cascate para ter uma boa interação entre as classes e os valores no banco de dados)

--controle de dados -- 
Insomnia


Requests 
--- GET--- 
Spotcrak/rest/cantor (retorna todos os cantores)
Spotcrak/rest/cantor/{id} (retorna um cantor especifico)

Spotcrak/rest/musica (retorna todos as musicas)
Spotcrak/rest/musica/{id} (retorna uma musica especifica)

--- POST---
Adiciona um cantor chamado poze
Spotcrak/rest/cantor/
{
  "nome": "poze"
}

Adiciona uma musica com o cantor com o {id} = 3
{
  "nome": "Vida",
  "dataLancamento": 2019		,
  "idCantor_id" : {"id": 3}
}
--- DELETE ---
http://localhost:8080/Spotcrak/rest/cantor/{id} (apaga o cantor de {id})
http://localhost:8080/Spotcrak/rest/musica/{id} (apaga musica de {id})


Quando um cantor é apagado todas as musicas que tem o "idCantor_id" igual ao id do cantor são apagados tbm 

Quando uma musica é apagada o "idCantor_id" tambem sera apagado, apagando todas as musicas que tenha o "Musica.idCantor_id" = Cantor.id