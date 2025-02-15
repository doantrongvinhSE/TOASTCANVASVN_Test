### Get Details One Book Request API

### Mô tả nghiệp vụ

Lấy ra chi tiết thông tin book của 1 request

### URL

Method `GET /api/v1/books/{id}`

### Request headers

Authorization: Bearer {access_token}
Content-Type: application/json

### Request parameters

| Param | Description | Type | Required | Check      |
|-------|-------------|------|----------|------------|
| id    | ID BOOK     | Long | true     | Không rỗng |

### Request body

N/A

#### JSON Example

N/A

#### Response Example

```json
{
  "code": "1000",
  "message": "Success",
  "data": {
    "title": "The Notebook",
    "publishedDate": "2024-12-12",
    "isbn": "978-3-16-14110-0",
    "price": 20000.0,
    "authors": [
      {
        "id": 12,
        "name": "Vinh",
        "nationality": "VN"
      },
      {
        "id": 1,
        "name": "Ly",
        "nationality": "CHN"
      }
    ]
  }
}
```

1. Kiểm tra param id xem có tồn tại trong database hay không. Nếu không trả về lỗi "not_found".
2. Trả về thông tin là request theo id truyền vào.