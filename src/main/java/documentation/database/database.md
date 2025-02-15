## Database structure for store book

Table books

| Field          | Type    | not null | Description         |
|----------------|---------|----------|---------------------|
| id             | Integer | X        | Primary key         |
| title          | String  | X        | Tiêu đề sách        |
| author_id      | Integer | X        | Mã của tác giả (FK) |
| published_date | Date    | X        | Ngày public         |
| isbn           | String  | X        | Code ISBN (unique)  |
| price          | Double  | X        | Giá sách            |

Table authors

| Field       | Type    | not null | Description |
|-------------|---------|----------|-------------|
| id          | Integer | X        | Primary key |
| name        | String  | X        | Tên tác giả |
| nationality | String  | X        | Quốc tịch   |

Table book_author

| Field     | Type    | not null | Description |
|-----------|---------|----------|-------------|
| book_id   | Integer | X        | FK          |
| author_id | Integer | X        | FK          |


