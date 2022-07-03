# PROVA DE PROGRAMAÇÃO WEB 👩‍💻

### QUESTÕES:

1. Crie um projeto com Spring Initializr incluindo Spring Boot Dev Tools, Lombok, Spring Web, 
Thymeleaf, Spring Data JPA, PostgreSQL Driver e Spring Validator. Crie a classe do modelo 
conforme o tema escolhido, lembre-se que você precisa adicionar pelo menos 7 atributos (ID, 
Deleted, ImageUri). Adicione as restrições (validações) do modelo. (0,5 ponto)

2. Crie a classe do usuário (id, username, password, admin, etc) que deve implementar a interface 
UserDetails. A aplicação os usuários poderão assumir 2 papeis (roles) “ROLE_ADMIN” e 
“ROLE_USER”. (0,5 ponto)

3. Prepare seus templates Thymeleaf para uso de bootstrap. Simplifique suas páginas utilizando 
fragments para separar, no mínimo, as partes de cabeçalho, principal e rodapé. A sugestão é o uso 
do template HTML disponível no [link](https://startbootstrap.com/template/shop-homepage). (1,0 ponto)

4. Implemente a rota de (“/index”) para, a partir de uma solicitação do tipo GET, gerar uma resposta 
contendo no corpo um HTML que contém uma tabela ou similar de todos os itens (linhas) que estão 
presentes no banco de dados e que não estão deletados (deleted == null). Você deve exibir a 
imagem de cada um dos itens da lista. Para cada item listado adicione um link para a rota 
“/adicionarCarrinho” passando como parâmetro para tal rota o ID do item escolhido. Por fim, adicione 
na página gerada pela rota “/index” um link para a rota “/verCarrinho”. Adicione um cookie na resposta 
chamado “visita” com a data e hora do acesso ao site. Esse cookie deve ser permanente e durar 
24hs. (1,0 ponto)

5. Implemente a rota de (“/admin”) para, a partir de uma solicitação do tipo GET, gerar uma resposta 
contendo no corpo um HTML que contém uma tabela de todos os itens (linhas) que estão presentes 
no banco de dados e que não estão deletados (deleted == null). Para cada item listado adicione um 
link para a rota “/editar” e “/deletar” passando como parâmetro para tal rota o ID do item escolhido. 
Por fim, adicione na página gerada pela rota “/admin” um link para a rota “/cadastro”. (1,0 ponto)

6. Implemente a rota de (“/cadastro”) para, a partir de uma solicitação do tipo GET, gerar uma 
resposta contendo no corpo um formulário HTML para cadastro de um item do seu tema. O formulário
deve conter um input de envio de arquivos para envio da imagem. O formulário deve conter tag para 
tratamento de erros utilizando o Thymeleaf. O formulário deve enviar os dados da solicitação através 
do método POST para a rota “/salvar”. (1,0 ponto)

7. Implemente a rota de (“/editar”) para, a partir de uma solicitação do tipo GET, gerar uma resposta 
contendo no corpo um formulário HTML para edição de um item do seu tema. Os dados do formulário
devem estar preenchidos com os dados daquele item no banco. O formulário deve conter tag para 
tratamento de erros utilizando o Thymeleaf. O formulário deve enviar os dados da solicitação através 
do método POST para a rota “/salvar”. Ao final do processo, a solicitação deve ser redirecionada para 
“/admin” enviando uma mensagem de que a atualização ocorreu com sucesso. (1,0 ponto)

8. Implemente a rota de (“/salvar”) que deve receber dados através de método POST e cadastrar ou 
atualizar um novo item no banco de dados. O método salvar deve validar os atributos do modelo. O 
método salvar deve criar um nome único para a imagem enviada. Caso ocorra algum erro, a resposta 
deve ser cancelada e o erro informado no formulário. Ao final do processo, a solicitação deve ser 
redirecionada para “/admin” enviando uma mensagem de que a atualização ocorreu com sucesso.
(1,0 ponto)

9. Implemente a rota de (“/deletar”) que deve receber dados através de método GET e atualizar um 
item no banco de dados para que o atributo Deleted contenha a data (Long) atual. Dessa forma, a 
operação de remoção de um registro será feita através de um soft delete, onde o registro do banco de 
dados não será apagado de fato. Ao final do processo, a solicitação deve ser redirecionada para 
“/index” enviando uma mensagem de que a remoção ocorreu com sucesso. (0,5 ponto)

10. Implemente a rota de (“/adicionarCarrinho”) que recebe uma solicitação do tipo GET contendo 
como parâmetro o id de um dos itens. Realize uma busca no banco de dados pelo item a partir do ID 
e adicione o objeto encontrado em uma Sessão HTTP no atributo “carrinho” que deve conter um 
ArrayList de itens. Encaminhe a resposta para a rota “/index”. Atualize a página “index” para que seja 
exibido a quantidade de itens no carrinho. (0,5 ponto)

11. Implemente a rota de (“/verCarrinho”) que ao receber uma solicitação do tipo GET lista todos os 
itens que estão no atributo “carrinho da Sessão HTTP. Se o carrinho estiver vazio, redirecione a 
resposta para “/index” enviando a mensagem de que não existem itens no carrinho. Por fim, adicione 
um link para a rota “/finalizarCompra”. (0,5 ponto)

12. Implemente a rota de (“/finalizarCompra”) que ao receber uma solicitação do tipo GET invalida a 
Sessão existente e redireciona a resposta para “index”. (0,5 ponto)

13. Adicione o Spring Security ao seu projeto e implemente o UserDetails Service. Configure a 
aplicação para que sejam cadastrados automaticamente 3 usuários sempre que a aplicação for 
executada, sendo eles um administrador e os outros dois usuários padrão. Configure o Spring 
Security para realizar a autenticação com base no seu UserDetails Service (que busca no banco de 
dados). Utilize BCrypt para codificar a senha. Configure as rotas para que um usuário não logado 
possa acessar a página de “/login” “/index”. Apenas um usuário com o papel “ROLE_ADMIN” poderá 
acessar as páginas “/admin” “/cadastro” “/salvar” “/editar” e “/deletar”. Apenas um usuário com o papel 
“ROLE_USER” poderá acessar as páginas “/vercarrinho”, “/adicionarcarrinho”, “/finalizarcompra”.
Adicione o username do usuário logado no cabeçalho. Adicione um botão para “logout” no cabeçalho.
(1,0 ponto)
