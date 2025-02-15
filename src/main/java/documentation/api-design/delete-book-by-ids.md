### DELETE BOOK REQUEST

### Mô tả nghiệp vụ

Xoá 1 hoặc nhiều sách bằng id.

### URL

Method `DELETE /api/v1/books`

### Request headers

Authorization: Bearer {access_token}
Content-Type: application/json

### Request parameters

N/A

### Request body

| Param | Description    | Type | Required | Check                |
|-------|----------------|------|----------|----------------------|
| ids   | ID các request | List | true     | Có ít nhất 1 phần tử |

#### JSON EXAMPLE

```json
{
  "ids": [1889959690667057152, 1889959706471194624]
}
```

### Response

```json
{
  "code": "1000",
  "message": "Success",
  "data": [
    {
      "id": 1889959690667057152,
      "title": "THE GODFATHER"
    },
    {
      "id": 1889959706471194624,
      "title": "THE NOTEBOOK"
    }
  ]
}
```

### Logic thực hiện

1. Kiểm tra từng requestId có tồn tại trong bảng `books` hay không. Nếu không tả về lỗi "invalid.requestId".
2. Trả về JSON response như trên.
