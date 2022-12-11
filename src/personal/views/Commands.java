package personal.views;

public enum Commands {
    NONE,
    READ, //выводит пользователя по id
    CREATE, //создает пользователя
    UPDATE, //обновляет данные о пользователе
    LIST, //выводит список всех пользователей
    DELETE, //удаляет пользователя из списка
    EXIT //выход из программы
}
