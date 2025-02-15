### Mô tả nghiệp vụ

Chỉnh sửa yêu cầu book.

### URL

Method `PUT /api/v1/books/{id}`

### Request header

N/A

### Request parameter

| Param | Description | Type |
|-------|-------------|------|
| Id    | Id của book | Long |

### Request body

| Param         | Description  | Type     | Required | Check                         |
|---------------|--------------|----------|----------|-------------------------------|
| title         | Tiêu đề sách | String   | true     | Không null                    |
| authorIds     | Id tác giả   | Long     | true     | Không null                    |
| publishedDate | Ngày công bố | Date     | true     | Không null, đúng kiểu dữ liệu |
| isbn          | Code ISBN    | NOT NULL | true     | Không null                    |
| price         | Giá sách     | String   | true     | Không null                    |

### Request Example

```json
{
   "title": "CR7 Story",
   "authorIds": [
      1
   ],
   "publishedDate": "2024-12-12",
   "isbn": "9712-3-4110-0",
   "price": 20000
}
```

### Response

```json
{
   "code": "1000",
   "message": "Success",
   "data": {
      "id": 1889963136811327488,
      "title": "CR7 Story",
      "publishedDate": "2024-12-12",
      "isbn": "9712-3-4110-0",
      "price": 20000.0,
      "authors": [
         {
            "id": 1,
            "name": "Ly",
            "nationality": "CHN"
         }
      ]
   }
}
```

### Logic thực hiện

1. Xử lý lỗi liên quan đến ID:
    - Kiểm tra id tồn tại trong bảng `books`. Nếu không,trả về lỗi `book.not.found`.
    - Kiểm tra Id author tồn tại trong bảng `authors`. Nếu không, trả về lỗi `author.not.found`.
2. Kiểm tra tính hợp lệ của price > 0.
3. Kiểm tra isbn exit. Nếu tồn tại trả về lỗi `isbn.exit`
3. Trả về phản hồi:
    - Nếu lưu thành công, trả về trạng thái 00 "Success".
    - Nếu gặp lỗi trong quá trình lưu, trả về mã lỗi phù hợp và thông báo chi tiết.