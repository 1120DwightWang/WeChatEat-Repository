# API

### Product List

```
GET /sell/buyer/product/list
```

Parameters

```
None
```

Return

```
{
    "code": 0,
    "msg": "Success",
    "data": [
        {
            "name": "HOT",
            "type": 1,
            "foods": [
                {
                    "id": "123456",
                    "name": "shrimp",
                    "price": 1.2,
                    "description": "yummy shrimp",
                    "icon": "http://xxx.com",
                }
            ]
        },
        {
            "name": "Boys' Favorite",
            "type": 2,
            "foods": [
                {
                    "id": "123457",
                    "name": "chicken wings",
                    "price": 10.9,
                    "description": "yummy chicken wings",
                    "icon": "http://xxx.com",
                }
            ]
        }
    ]
}
```


### Create Order

```
POST /sell/buyer/order/create
```

Parameters

```
name: "Dwight"
phone: "18868822111"
address: "Beijing"
openid: "ew3euwhd7sjw9diwkq" //WeChat User's openid
items: [{
    productId: "1423113435324",
    productQuantity: 2 
}]

```

Return

```
{
  "code": 0,
  "msg": "Success",
  "data": {
      "orderId": "147283992738221" 
  }
}
```

### Order List

```
GET /sell/buyer/order/list
```

Parameters

```
openid: 18eu2jwk2kse3r42e2e
page: 0 //starts from page 0
size: 10
```

Return

```
{
  "code": 0,
  "msg": "Success",
  "data": [
    {
      "orderId": "161873371171128075",
      "buyerName": "Elaine",
      "buyerPhone": "18868877111",
      "buyerAddress": "US",
      "buyerOpenid": "18eu2jwk2kse3r42e2e",
      "orderAmount": 0,
      "orderStatus": 0,
      "payStatus": 0,
      "createTime": 1490171219,
      "updateTime": 1490171219,
      "orderDetailList": null
    },
    {
      "orderId": "161873371171128076",
      "buyerName": "Elaine",
      "buyerPhone": "18868877111",
      "buyerAddress": "US",
      "buyerOpenid": "18eu2jwk2kse3r42e2e",
      "orderAmount": 0,
      "orderStatus": 0,
      "payStatus": 0,
      "createTime": 1490171219,
      "updateTime": 1490171219,
      "orderDetailList": null
    }]
}
```

### Order Detail

```
GET /sell/buyer/order/detail
```

Parameters

```
openid: 18eu2jwk2kse3r42e2e
orderId: 161899085773669363
```

Return

```
{
    "code": 0,
    "msg": "Success",
    "data": {
          "orderId": "161899085773669363",
          "buyerName": "Jack",
          "buyerPhone": "18868877111",
          "buyerAddress": "Canada",
          "buyerOpenid": "18eu2jwk2kse3r42e2e",
          "orderAmount": 18,
          "orderStatus": 0,
          "payStatus": 0,
          "createTime": 1490177352,
          "updateTime": 1490177352,
          "orderDetailList": [
            {
                "detailId": "161899085974995851",
                "orderId": "161899085773669363",
                "productId": "157875196362360019",
                "productName": "Porridge",
                "productPrice": 9,
                "productQuantity": 2,
                "productIcon": "http://xxx.com",
                "productImage": "http://xxx.com"
            }
        ]
    }
}
```

### Cancel Order

```
POST /sell/buyer/order/cancel
```

Parameters

```
openid: 18eu2jwk2kse3r42e2e
orderId: 161899085773669363
```

Return

```
{
    "code": 0,
    "msg": "成功",
    "data": null
}
```

### Get openid

```
重定向到 /sell/wechat/authorize
```

Parameters

```
returnUrl: http://xxx.com/abc  //must fill
```

Return

```
http://xxx.com/abc?openid=oZxSYw5ldcxv6H0EU67GgSXOUrVg
```

### Pay Order
```
redirect /sell/pay/create
```

Parameters

```
orderId: 161899085773669363
returnUrl: http://xxx.com/abc/order/161899085773669363
```

Return

```
http://xxx.com/abc/order/161899085773669363
```


