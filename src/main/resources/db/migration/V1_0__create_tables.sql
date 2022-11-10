
CREATE SCHEMA RecipeBook;

CREATE TABLE "RecipeBook".users(
    id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    login VARCHAR(20) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    role VARCHAR(10) NOT NULL DEFAULT 'ROLE_USER',
    CHECK ( role = 'ROLE_USER' or role = 'ROLE_ADMIN' )
);

CREATE TABLE "RecipeBook".recipes(
    id INTEGER UNIQUE GENERATED ALWAYS AS IDENTITY,
    name VARCHAR(100) NOT NULL,
    image bytea,
    users_id INTEGER NOT NULL,
    public BOOLEAN NOT NULL DEFAULT FALSE,
    comment VARCHAR(300),
    -- При удалении пользователя будут удаляться все рецепты
    FOREIGN KEY (users_id) REFERENCES "RecipeBook"."users" (id) ON DELETE CASCADE,
    PRIMARY KEY (id, users_id)
);

CREATE TABLE "RecipeBook".products(
    id INTEGER GENERATED ALWAYS AS IDENTITY,
    recipes_id INTEGER NOT NULL,
    name VARCHAR(30) NOT NULL ,
    comment VARCHAR(300),
    quantity VARCHAR(20),
    -- При удалении рецепта будут удаляться все продукты
    FOREIGN KEY (recipes_id) REFERENCES "RecipeBook"."recipes" (id) ON DELETE CASCADE,
    PRIMARY KEY (id, recipes_id)
);

CREATE TABLE "RecipeBook".actions(
    id INTEGER GENERATED ALWAYS AS IDENTITY,
    recipes_id INTEGER NOT NULL,
    description VARCHAR(300) NOT NULL,
    comment VARCHAR(300),
    index_number INTEGER NOT NULL,
    -- При удалении рецепта все действия также будут удалены
    FOREIGN KEY (recipes_id) REFERENCES "RecipeBook"."recipes" (id) ON DELETE CASCADE,
    PRIMARY KEY (id, recipes_id)

)