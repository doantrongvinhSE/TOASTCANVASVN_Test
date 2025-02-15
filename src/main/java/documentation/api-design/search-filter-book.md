### Get Details One Book Request API

### Mô tả nghiệp vụ

Lấy ra chi tiết thông tin các books filter theo điều kiện: 
- Giá thấp hơn, cao hơn
- Tiêu đề sách
- Sau ngày xuất bản

### URL

Method `GET /api/v1/books/search?minPrice={minPrice}&maxPrice={maxPrice}&title={title}&publishedDate={publishedDate}`

### Request headers

Authorization: Bearer {access_token}
Content-Type: application/json

### Request parameters

| Param         | Description   | Type   | Required | Check |
|---------------|---------------|--------|----------|-------|
| title         | Tiêu đề sách  | String | false    |       |
| minPrice      | Giá thấp nhất | Double | false    |       |
| maxPrice      | Giá cao nhất  | Double | false    |       |
| publishedDate | Ngày xuất bản | Date   | false    |       |

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

