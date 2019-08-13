# Desafio Java [Hands On]

# Installation

Just import project into Spring

# Usage

###### Start server java -jar tokyo2020-0.0.1-SNAPSHOT.jar

Adding some competitions

    $ curl -i -X POST -H "Content-Type:application/json" -d "{  \"modalidade\" : \"Futebol\",  \"local\" : \"Mineirao\",  \"pais1\" : \"Brasil\",  \"pais2\" : \"Alemanha\",  \"etapa\" : \"Eliminatórias\",  \"datahoraInicio\" : \"2017-10-29T8:00:00Z\",  \"datahoraFim\" : \"2017-10-29T9:00:00Z\", \"valor1\" : 1, \"valor2\" : 2 }" http://localhost:8080/competicao;

    $ curl -i -X POST -H "Content-Type:application/json" -d "{  \"modalidade\" : \"Futebol\",  \"local\" : \"Mineirao\",  \"pais1\" : \"Argentina\",  \"pais2\" : \"Chile\",  \"etapa\" : \"Eliminatórias\",  \"datahoraInicio\" : \"2017-10-29T10:00:00Z\",  \"datahoraFim\" : \"2017-10-29T11:00:00Z\", \"valor1\" : 1, \"valor2\" : 2 }" http://localhost:8080/competicao;

    $ curl -i -X POST -H "Content-Type:application/json" -d "{  \"modalidade\" : \"Futebol\",  \"local\" : \"Mineirao\",  \"pais1\" : \"EUA\",  \"pais2\" : \"Paraguai\",  \"etapa\" : \"Eliminatórias\",  \"datahoraInicio\" : \"2017-10-29T12:00:00Z\",  \"datahoraFim\" : \"2017-10-29T13:00:00Z\", \"valor1\" : 1, \"valor2\" : 2 }" http://localhost:8080/competicao;

    $ curl -i -X POST -H "Content-Type:application/json" -d "{  \"modalidade\" : \"Futebol\",  \"local\" : \"Mineirao\",  \"pais1\" : \"Equador\",  \"pais2\" : \"Bolivia\",  \"etapa\" : \"Eliminatórias\",  \"datahoraInicio\" : \"2017-10-29T14:00:00Z\",  \"datahoraFim\" : \"2017-10-29T15:00:00Z\", \"valor1\" : 1, \"valor2\" : 2 }" http://localhost:8080/competicao;

    $ curl -i -X POST -H "Content-Type:application/json" -d "{  \"modalidade\" : \"Futebol\",  \"local\" : \"Mineirao\",  \"pais1\" : \"Venezuela\",  \"pais2\" : \"Colombia\",  \"etapa\" : \"Eliminatórias\",  \"datahoraInicio\" : \"2017-10-29T16:00:00Z\",  \"datahoraFim\" : \"2017-10-29T17:00:00Z\", \"valor1\" : 1, \"valor2\" : 2 }" http://localhost:8080/competicao;

etapa errada

    $ curl -i -X POST -H "Content-Type:application/json" -d "{  \"modalidade\" : \"Basquete\",  \"local\" : \"Mineirao\",  \"pais1\" : \"Venezuela\",  \"pais2\" : \"Colombia\",  \"etapa\" : \"Eliminatórias\",  \"datahoraInicio\" : \"2017-10-30T16:00:00Z\",  \"datahoraFim\" : \"2017-10-30T16:20:00Z\", \"valor1\" : 1, \"valor2\" : 1 }" http://localhost:8080/competicao
    
Listing all competitions

    $ curl -i -X GET http://localhost:8080/competicao/search/listCompeticoes
    
Listing all competitions filtering by modalidde

    $ curl -i -X GET http://localhost:8080/competicao/search/listCompeticoes?modalidade=Futebol

# Documentation

##### Apresentação do desafio
###### A proposta do desafio é a criação de uma API RESTful, para gerir dados das competições dos Jogos Olímpicos Tokyo 2020. O objetivo é a criação dos seguintes endpoints:
* Cadastro das competições que ocorrerão nos Jogos Olímpicos Tokyo 2020.
* Consultas das competições cadastradas
###### Cada competição cadastrada deve conter obrigatoriamente as seguintes informações:
* Modalidade (Ex: Futebol, Basquete, etc)
* Local
* Data/Hora de início/término
* Os 2 países envolvidos na disputa
* Etapa - Deve contemplar as seguintes opções: Eliminatórias, Oitavas de Final, Quartas
de Final, Semifinal, Final
###### As seguintes regras devem ser respeitadas no fluxo de cadastro das competições:
* Duas competições não podem ocorrer no mesmo período, no mesmo local, para a
mesma modalidade. Ex: Se eu tenho uma partida de futebol que com início às 18:00 e término às 20:00 no Estádio 1, eu não poderia ter outra partida de futebol se iniciando às 19:30 nesse mesmo estádio
* O fluxo de cadastro deve permitir que se forneça o mesmo valor, para os 2 países envolvidos na disputa, apenas se a etapa for Final ou Semifinal. Para as demais etapas, não se deve permitir que se forneça o mesmo valor.
* A competição deve ter a duração de no mínimo 30 minutos.
* Para evitar problemas, a organização das olimpíadas que limitar a no máximo 4
competições por dia num mesmo local
* Para situações de erro, é necessário que a resposta da requisição seja coerente em
exibir uma mensagem condizente com o erro.
###### O endpoint de consulta de competições cadastradas, deve retornar os resultados ordenados por Data/Hora de início da competição e deve permitir filtrar todas competições para uma dada modalidade. Esse filtro não é obrigátorio - se não for fornecido todas competições devem ser retornadas
###### Pontos relevantes
* Utilize a plataforma Java para o desenvolvimento da solução do desafio
* Fique a vontade na escolha de frameworks e bibliotecas que quiser usar no projeto
* Fique a vontade com relação a parte de persistência. Uma sugestão é a utilização de
banco de dados em memória, como HSQLDB
