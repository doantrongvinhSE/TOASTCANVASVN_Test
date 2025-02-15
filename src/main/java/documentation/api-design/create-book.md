### Create OT Request

### Mô tả nghiệp vụ

Tạo 1 request thêm mới sách

### URL

Method `POST /api/v1/books`

### Request headers

Authorization: Bearer {access_token}
Content-Type: application/json

### Request parameters

N/A

### Request body

| Param         | Description  | Type       | Required | Check                         |
|---------------|--------------|------------|----------|-------------------------------|
| title         | Tiêu đề sách | String     | true     | Không null                    |
| authorIds     | Id tác giả   | List<Long> | true     | Không null                    |
| publishedDate | Ngày công bố | Date       | true     | Không null, đúng kiểu dữ liệu |
| isbn          | Code ISBN    | NOT NULL   | true     | Không null                    |
| price         | Giá sách     | String     | true     | Không null                    |

#### JSON EXAMPLE

```json
{
  "title": "THE GODFATHER",
  "authorIds": [
    1,
    12
  ],
  "publishedDate": "2024-12-12",
  "isbn": "9712-3-16-1114110-0",
  "price": 20000
}
```

### Response

```json
{
  "code": "1000",
  "message": "Success",
  "data": {
    "title": "THE GODFATHER",
    "publishedDate": "2024-12-12",
    "isbn": "9712-3-16-1114110-0",
    "price": 20000.0,
    "authors": [
      {
        "id": 1,
        "name": "Ly",
        "nationality": "CHN"
      },
      {
        "id": 12,
        "name": "Vinh",
        "nationality": "VN"
      }
    ]
  }
}
```

### Logic thực hiện

1. Kiểm tra các trường request có thiếu hay không. Nếu không tả về lỗi "required.field".
2. Kiểm tra author_id có tồn tại trong Database hay không. Nếu không trả về lỗi "author.not.found".
3. Nếu mã isbn exit trả về lỗi "isbn.exit"
4. Nếu thành công trả về response.
