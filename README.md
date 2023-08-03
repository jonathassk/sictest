# sictest
## Documentação/readme de teste para vaga de desenvolvedor back-end 

### Como Iniciar aplicação? 
Para rodar a aplicação, vai ser necessario rodar iniciar um banco de dados postgres, o mesmo se encontra configurado na no docker-compose que pode ser encontrado na raiz do projeto.
Apos isso pode iniciar a aplicacao normalmente. Para testar o funcionamento das aplicações em si, pode usar a documentação do swagger que esta nesse [LINK](http://localhost:8080/swagger-ui/index.html)

### Como foi feita a verificacao de cpf 
Diferente do que foi pedido no projeto, acabei por utilizar a requisição de um site que faz a verificacao de url, e usava o campo de validação para aprovar/reprovar os proximos passos, nos testes de performance (fotos abaixo) percebi que foi o que mais causou perca de desempenho (possivle ver nos logs que foram adicionados), mas por se tratar de um projeto para mostrar qualificacao, acabei ignorando isso por nao ter muito tempo livre para fazer melhorias 

### Testes unitarios
Foi feito testes unitarios em garnde parte dos services, tambem por conta do tempo, acabei focando nos testes de "cenario feliz", mas mesmo assim, a media de cobertura foi acima de 85% em ambos services.

###
