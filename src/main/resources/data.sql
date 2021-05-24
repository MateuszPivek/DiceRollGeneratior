-- Przykład skryptu do którego możemy dodać dane podczas uruchamiania aplikacji
insert into blog.quiz(question, option1, option2, option3, option4, answer)
values       ('Kiedy powstała Java', '1990','1994','1996','2000', '1994'),
             ('Które słowo kluczowe tworzy obiekty?', 'create','new','instance','for', 'new'),
             ('Która inicjacja zmiennej `int a` jest poprawna?', 'int a = 10.0;','int a = 10L;','int a = 10;','int a = "10";', 'int a = 10;');
