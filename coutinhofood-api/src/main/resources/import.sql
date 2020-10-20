insert into estado(UF , nome) values ('SP' , 'São Paulo');
insert into estado(UF , nome) values ('RJ' , 'Rio de Janeiro');
insert into estado(UF , nome) values ('BA' , 'Bahia');


insert into cidade(nome , UF) values ('Santo André' , 'SP');
insert into cidade(nome , UF) values ('São Paulo' , 'SP');

insert into forma_pagamento(descricao) values ("Cartão-Crédito");
insert into forma_pagamento(descricao) values ("Cartão-Débito");
insert into forma_pagamento(descricao) values ("Dinheiro");

insert into cozinha(nome) values ('Tailandesa');
insert into cozinha(nome) values ('Indiana');

insert into restaurante(nome,taxa_frete,cozinha_id,forma_pagamento_id ) values ("Thai Gourmet" , 10.50,1,1);
insert into restaurante(nome,taxa_frete,cozinha_id,forma_pagamento_id ) values ("Thai Delivery" , 8.50,1,3);
insert into restaurante(nome,taxa_frete,cozinha_id,forma_pagamento_id ) values ("Tuk Tuk Cozinha Indiana" , 15.0,2,2);


insert into restaurante_forma_pagamento('1','1');
insert into restaurante_forma_pagamento('1','2');
insert into restaurante_forma_pagamento('1','3');