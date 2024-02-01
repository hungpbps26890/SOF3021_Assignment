USE [SOF3021_J5_CoffeeShop]
GO
INSERT [dbo].[users] ([username], [active], [admin], [email], [first_name], [last_name], [password], [phone_number]) VALUES (N'admin', 1, 1, N'admin@gmail.com', N'admin', N'nguyen', N'123456', N'0123456789')
GO
INSERT [dbo].[users] ([username], [active], [admin], [email], [first_name], [last_name], [password], [phone_number]) VALUES (N'user001', 1, 0, N'user@gmailcom', N'User', N'Nguyễn', N'123456', N'0123456789')
GO
SET IDENTITY_INSERT [dbo].[categories] ON 
GO
INSERT [dbo].[categories] ([id], [name]) VALUES (1, N'Cà Phê Việt Nam')
GO
INSERT [dbo].[categories] ([id], [name]) VALUES (2, N'Cà Phê Máy')
GO
INSERT [dbo].[categories] ([id], [name]) VALUES (3, N'Cold Brew')
GO
INSERT [dbo].[categories] ([id], [name]) VALUES (4, N'Trà Trái Cây')
GO
INSERT [dbo].[categories] ([id], [name]) VALUES (5, N'Trà Sữa Macchiato')
GO
INSERT [dbo].[categories] ([id], [name]) VALUES (6, N'CloudFee')
GO
INSERT [dbo].[categories] ([id], [name]) VALUES (7, N'CloudTea Mochi')
GO
INSERT [dbo].[categories] ([id], [name]) VALUES (8, N'Hi-Tea Trà')
GO
INSERT [dbo].[categories] ([id], [name]) VALUES (9, N'Hi-Tea Đá Tuyết')
GO
INSERT [dbo].[categories] ([id], [name]) VALUES (10, N'Trà Xanh Tây Bắc')
GO
INSERT [dbo].[categories] ([id], [name]) VALUES (11, N'Chocolate')
GO
SET IDENTITY_INSERT [dbo].[categories] OFF
GO
SET IDENTITY_INSERT [dbo].[drinks] ON 
GO
INSERT [dbo].[drinks] ([id], [active], [description], [drink_image], [name], [price], [category_id]) VALUES (1, 1, N'Nếu chuộng vị cà phê đậm đà, bùng nổ và thích vị đường đen ngọt thơm, Đường Đen Sữa Đá đích thị là thức uống dành cho bạn. Không chỉ giúp bạn tỉnh táo buổi sáng, Đường Đen Sữa Đá còn hấp dẫn đến ngụm cuối cùng bởi thạch cà phê giòn dai, nhai cực cuốn. - Khuấy đều trước khi sử dụng', N'1.webp', N'Đường Đen Sữa Đá', 45000, 1)
GO
INSERT [dbo].[drinks] ([id], [active], [description], [drink_image], [name], [price], [category_id]) VALUES (2, 1, N'Thức uống giúp tỉnh táo tức thì để bắt đầu ngày mới thật hứng khởi. Không đắng khét như cà phê truyền thống, The Coffee House Sữa Đá mang hương vị hài hoà đầy lôi cuốn. Là sự đậm đà của 100% cà phê Arabica Cầu Đất rang vừa tới, biến tấu tinh tế với sữa đặc và kem sữa ngọt ngào cực quyến rũ. Càng hấp dẫn hơn với topping thạch 100% cà phê nguyên chất giúp giữ trọn vị ngon đến ngụm cuối cùng.', N'2.webp', N'The Coffee House Sữa Đá', 39000, 1)
GO
INSERT [dbo].[drinks] ([id], [active], [description], [drink_image], [name], [price], [category_id]) VALUES (3, 1, N'Cà phê Đắk Lắk nguyên chất được pha phin truyền thống kết hợp với sữa đặc tạo nên hương vị đậm đà, hài hòa giữa vị ngọt đầu lưỡi và vị đắng thanh thoát nơi hậu vị.', N'3.webp', N'Cà Phê Sữa Đá', 29000, 1)
GO
INSERT [dbo].[drinks] ([id], [active], [description], [drink_image], [name], [price], [category_id]) VALUES (4, 1, N'Cà phê được pha phin truyền thống kết hợp với sữa đặc tạo nên hương vị đậm đà, hài hòa giữa vị ngọt đầu lưỡi và vị đắng thanh thoát nơi hậu vị.', N'4.webp', N'Cà Phê Sữa Nóng', 39000, 1)
GO
INSERT [dbo].[drinks] ([id], [active], [description], [drink_image], [name], [price], [category_id]) VALUES (5, 1, N'Bạc sỉu chính là "Ly sữa trắng kèm một chút cà phê". Thức uống này rất phù hợp những ai vừa muốn trải nghiệm chút vị đắng của cà phê vừa muốn thưởng thức vị ngọt béo ngậy từ sữa.', N'5.jpg', N'Bạc Sỉu', 29000, 1)
GO
INSERT [dbo].[drinks] ([id], [active], [description], [drink_image], [name], [price], [category_id]) VALUES (6, 1, N'Bạc sỉu chính là "Ly sữa trắng kèm một chút cà phê". Thức uống này rất phù hợp những ai vừa muốn trải nghiệm chút vị đắng của cà phê vừa muốn thưởng thức vị ngọt béo ngậy từ sữa.', N'6.webp', N'Bạc Sỉu Nóng', 39000, 1)
GO
SET IDENTITY_INSERT [dbo].[drinks] OFF
GO
