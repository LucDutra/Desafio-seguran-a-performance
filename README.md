# Desafio-security

     Primeiramente obrigado por visitar meu repositorio, qualquer contribuição ou dica fico
 totalmente a disposição.
  
    Importante: 
    -Para execução deste projeto será necesario ter instaldo e configurado em 
    sua maquina uma JDK11 ou superior;
    -Para teste das requisições indica-se o postman;
    -Para utilização desta projeto, basta importa-lo em sua IDE de preferencia 
  
      Antes de você olhar o codigo desenvolvido até o momento, peço para que entre 
 na pasta "Documentação", nesta pasta possui um .pdf que explica  o por que do 
 desenvolviemnto deste código, qual foi a minha ideia de desenvolvimento
 e também qual a minha ideia para os proximos passos. Além deste .pdf 
 possui uma collection para ser importada no postman, onde contem 
 todos os endpoints já construidos até o momento, facilitando a utilização desta aplicação.
    
    Desenvolvido até o momento:
    
    Neste primeiro momento, foquei na construção da estrutura de segurança da aplicação,
então esta aplicação ainda não tem nenhuma  estrutura com algum banco de dados ou com o Redis, 
porém são os planos futuros. Atualmente os dados de Login, e o retorno os endpoints 
estão "Chumbados" no fonte para fins de testes.
  
     A ideia desta implementação é que para cada endpoint de acesso seja gerado 
um token diferente, com regras de expiração diferentes respeitando  
o nivel critico de cada um. Segue passo a passo de testes:
    
    No endpoint: Login, o body já esta previamente preenchido, 
e como falado anteriomente os dados de Login estão fixos, 
exceto o item "baseAcessoSolicitada", neste campo você tem as seguintes 
opções: "BASEA", "BASEB", "BASEC". Para cada opção informada 
será gerado um token diferente, seguindo a seguinte logica de expiração:
    
    BaseA - 30Sec;
    BaseB - 1Min;
    BaseC - 10Min;
    
    O token de cada base é unico para ela, então caso gerado um token
para a "BASE C" ele será utilizavel unica e exclusivemnte para a Base C, e assim para cada respectiva base.
O token gerado precisa ser adicionado na aba "Authorization" do postman 
e o Type deverá ser o "Beare Token".

    A partir do token gerado e registrado na aba "Authroizathion" fique a vontade para utilizar o endpoint desejado.
    
    
    Conforme descrito na documentação, as proximas implementações serão:
    
    -Conexação com o banco de dados, relaciona e não relacional;
    -Endpoint de cadastro de usuario;
    -Endpoint de cadastro de para o usuario;
    -Armazenamento e gerenciamento de cache com o Redis.
    -Configuração da aplicação com o docker.
    -Construção do endpoint da base C, utilizando o Quarkus.
    
    
    
