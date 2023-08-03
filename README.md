# sictest
## Documentação/readme de teste para vaga de desenvolvedor back-end 

### Como Iniciar aplicação? 
Para rodar a aplicação, vai ser necessario rodar iniciar um banco de dados postgres, o mesmo se encontra configurado na no docker-compose que pode ser encontrado na raiz do projeto.
Apos isso pode iniciar a aplicacao normalmente. Para testar o funcionamento das aplicações em si, pode usar a documentação do swagger que esta nesse [LINK](http://localhost:8080/swagger-ui/index.html)

### Como foi feita a verificacao de cpf 
Diferente do que foi pedido no projeto, acabei por utilizar a requisição de um site que faz a verificacao de url, e usava o campo de validação para aprovar/reprovar os proximos passos, nos testes de performance (fotos abaixo) percebi que foi o que mais causou perca de desempenho (possivle ver nos logs que foram adicionados), mas por se tratar de um projeto para mostrar qualificacao, acabei ignorando isso por nao ter muito tempo livre para fazer melhorias 

### Testes unitarios
Foi feito testes unitarios em garnde parte dos services, tambem por conta do tempo, acabei focando nos testes de "cenario feliz", mas mesmo assim, a media de cobertura foi acima de 85% em ambos services.

<img width="623" alt="image" src="https://github.com/jonathassk/sictest/assets/35012537/4d1c7736-0eb0-4bd7-9f85-0591941c7d5f">

### Teste de Performance

<img width="1239" alt="image" src="https://github.com/jonathassk/sictest/assets/35012537/84348147-1738-4267-b3f9-1579c22b2213">
resultados finais de media/mediana/percentil na consulta de enquetes

## versionamento
### Como voce versionaria sua aplicação?
Em um projeto real, eu faria o versionamento dele em uma plataforma como github ou gitlab, utilizando a convenção de termos MAJOR, MINOR E PATCH. Onde a alteracao do major, seria feita para quando fosse para grande mudancas, fazendo sim ser considerada uma nova versao, os minors seriam para pequenas alteracões ou pequenos acrescimos de funções e os patchs serao correcao de bugs, deixando os valores nas tags como 1.0.0 apos o deploy.
Mas antes de oficialmente publicar em prod, para fazer a transicao entre os ambientes, teria o ambiente de dev, homol e main, alem do release-candidate para ser enviado antes de ser mandado para produção, onde nesses ambientes seriam feitos os testes de desempenho, funcionamento no ambiente real, homologacao, e2e etc...

