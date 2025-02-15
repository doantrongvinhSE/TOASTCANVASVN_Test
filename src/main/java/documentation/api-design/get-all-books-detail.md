### Get Details All Book Request API

### Mô tả nghiệp vụ

Lấy ra chi tiết thông tin tất cả books của 1 request

### URL

Method `GET /api/v1/books`

### Request headers

Authorization: Bearer {access_token}
Content-Type: application/json

### Request parameters

N/A

### Request body

N/A

#### JSON Example

N/A

#### Response Example

```json
{
  "code": "1000",
  "message": "Success",
  "data": [
    {
      "id": 1889963065814343680,
      "title": "BO TU SIEU DANG",
      "publishedDate": "2024-12-12",
      "isbn": "9712-3-16-1121114110-0",
      "price": 1999.0,
      "authors": [
        {
          "id": 12,
          "name": "Vinh",
          "nationality": "VN"
        }
      ]
    },
    {
      "id": 1890302141292167168,
      "title": "THE",
      "publishedDate": "2024-12-12",
      "isbn": "9712-312110-0",
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
  ]
}
```

