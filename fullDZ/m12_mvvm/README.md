## Урок 12. Архитектура презентационного слоя

---
## Цель практической работы:
Применить знания по архитектуре MVVM, отработать сохранение и изменение состояния экрана через ViewModel.

## Что нужно сделать
Создайте экран поиска:
1. Сверстайте экран, на котором будет поисковая строка, кнопка поиска и TextView с текстом «Здесь будет отображаться результат запроса» или с любым другим на ваше усмотрение.
2. Сделайте так, чтобы кнопка поиска была заблокирована, если в поисковой строке меньше трёх символов или идёт поиск.
3. Задайте, чтобы после ввода текста и нажатия на поиск отображался прогресс.
4. Сымитируйте процесс выполнения запроса с помощью корутин и функции delay, как было показано в видеоматериале.
5. Убедитесь, что после того, как поиск завершён, прогресс исчезает и отображается текст «По запросу <текст запроса> ничего не найдено».

## Что оценивается
- После запуска поиска, если повернуть экран, поиск продолжается, а не прерывается.
- Любое состояние экрана не изменяется при повороте, а только по результатам действий пользователя или выполнения запроса.
- Нет багов и вылетов.
- Код чистый, у переменных и компонентов понятные названия, соблюдаются принципы ООП.

## Как отправить работу на проверку
- Используйте репозиторий android_dev_1_2022.
- Скачайте изменения в репозитории на ваш компьютер.
- Выполните практическую работу в папке m12_mvvm. Отправьте коммиты в удалённый репозиторий.

## Решение: m12_mvvm