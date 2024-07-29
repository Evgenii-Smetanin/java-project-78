##### Maintainability:
<a href="https://codeclimate.com/github/Evgenii-Smetanin/java-project-78/maintainability"><img src="https://api.codeclimate.com/v1/badges/eb66c072c54a58ac7998/maintainability" /></a>
##### Test Coverage:
<a href="https://codeclimate.com/github/Evgenii-Smetanin/java-project-78/test_coverage"><img src="https://api.codeclimate.com/v1/badges/eb66c072c54a58ac7998/test_coverage" /></a>
##### Build status:
[![Java CI with Gradle](https://github.com/Evgenii-Smetanin/java-project-78/actions/workflows/gradle.yml/badge.svg)](https://github.com/Evgenii-Smetanin/java-project-78/actions/workflows/gradle.yml)
##### Hexlet tests and linter status:
[![Actions Status](https://github.com/Evgenii-Smetanin/java-project-78/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/Evgenii-Smetanin/java-project-78/actions)

## Проект "Валидатор данных"
\
\
hexlet.code
### Class Validator
Основной класс для работы с библиотекой. Включает методы для получения объектов для валидации данных.
```
Validator()
Инициализирует новый объект валидатора.

<K, V> MapSchema<K, V> map()
Возвращает объект MapSchema<K, V> для валидации Map.

NumberSchema number()
Возвращает объект NumberSchema для валидации чисел.

StringSchema string()
Возвращает объект StringSchema для валидации строк.
```
\
\
hexlet.code.schemas
### Class BaseSchema\<T\>
Базовый класс для валидации данных.
```
BaseSchema()
Инициализирует новый объект BaseSchema<T>.

boolean isValid(T obj)
Выполняет проверку переданного объекта в соответствии со схемой валидации и возвращает true, если проверка пройдена, иначе false.

BaseSchema<T> required()
добавляет в схему валидации проверку валидируемого объекта на null и возвращает объект схемы.
```
\
\
hexlet.code.schemas
### Class StringSchema extends BaseSchema\<String\>
Класс для валидации строк.
```
StringSchema()
Инициализирует новый объект StringSchema.

StringSchema contains(String s)
добавляет в схему валидации проверку валидируемой строки на вхождение подстроки и возвращает объект схемы.

boolean isValid(String string)
Выполняет проверку переданной строки в соответствии со схемой валидации и возвращает true, если проверка пройдена, иначе false.

StringSchema minLength(int min)
добавляет в схему валидации проверку валидируемой строки на соответствие минимальной длине и возвращает объект схемы.

StringSchema required()
добавляет в схему валидации проверку валидируемой строки на null и isEmpty и возвращает объект схемы.
```
\
\
hexlet.code.schemas
### Class NumberSchema extends BaseSchema\<Integer\>
Класс для валидации чисел.
```
NumberSchema()
Инициализирует новый объект NumberSchema.

boolean isValid(Integer string)
Выполняет проверку переданного числа в соответствии со схемой валидации и возвращает true, если проверка пройдена, иначе false.

NumberSchema positive()
добавляет в схему валидации проверку валидируемого числа на положительное значение и возвращает объект схемы.

NumberSchema range(int minimum, int maximum)
добавляет в схему валидации проверку валидируемого числа на вхождение в диапазон (включая границы) и возвращает объект схемы.

NumberSchema required()
добавляет в схему валидации проверку валидируемого объекта на null и возвращает объект схемы.
```
\
\
hexlet.code.schemas
### Class MapSchema\<K, V\> extends BaseSchema\<Map\<K, V\>\>
Класс для валидации объектов Map.
```
MapSchema()
Инициализирует новый объект MapSchema<K, V>.

boolean isValid(Map<K, V> map)
Выполняет проверку переданного объекта Map в соответствии со схемой валидации и возвращает true, если проверка пройдена, иначе false.

MapSchema<K, V> shape(Map<String, BaseSchema<String>> schemaMap)
добавляет в схему валидации проверку данных внутри валидируемого объекта Map в соответствии с переданной Map, где ключом является имя валидируемого свойства, а значением - схема его валидации и возвращает объект схемы MapSchema<K, V>.

MapSchema<K, V> sizeof(int mapSize)
добавляет в схему валидации проверку валидируемой Map на соответствие размеру.

MapSchema<K, V> required()
добавляет в схему валидации проверку валидируемого объекта на null и возвращает объект схемы.
```
