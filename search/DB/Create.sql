create table documents
(
	id integer auto_increment,
	file_name varchar(50) not null,
	text longtext null,primary key (id)
);

create unique index documents_file_name_uindex
	on documents (file_name);

create unique index documents_id_uindex
	on documents (id);

 
		

