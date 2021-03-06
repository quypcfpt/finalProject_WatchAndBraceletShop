USE [master]
GO
/****** Object:  Database [PRX301_Project]    Script Date: 5/3/2019 7:57:04 PM ******/
CREATE DATABASE [PRX301_Project]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'PRX301_Project', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.MSSQLSERVER\MSSQL\DATA\PRX301_Project.mdf' , SIZE = 4096KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'PRX301_Project_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.MSSQLSERVER\MSSQL\DATA\PRX301_Project_log.ldf' , SIZE = 1536KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [PRX301_Project] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [PRX301_Project].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [PRX301_Project] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [PRX301_Project] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [PRX301_Project] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [PRX301_Project] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [PRX301_Project] SET ARITHABORT OFF 
GO
ALTER DATABASE [PRX301_Project] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [PRX301_Project] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [PRX301_Project] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [PRX301_Project] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [PRX301_Project] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [PRX301_Project] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [PRX301_Project] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [PRX301_Project] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [PRX301_Project] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [PRX301_Project] SET  DISABLE_BROKER 
GO
ALTER DATABASE [PRX301_Project] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [PRX301_Project] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [PRX301_Project] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [PRX301_Project] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [PRX301_Project] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [PRX301_Project] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [PRX301_Project] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [PRX301_Project] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [PRX301_Project] SET  MULTI_USER 
GO
ALTER DATABASE [PRX301_Project] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [PRX301_Project] SET DB_CHAINING OFF 
GO
ALTER DATABASE [PRX301_Project] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [PRX301_Project] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [PRX301_Project] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'PRX301_Project', N'ON'
GO
ALTER DATABASE [PRX301_Project] SET QUERY_STORE = OFF
GO
USE [PRX301_Project]
GO
ALTER DATABASE SCOPED CONFIGURATION SET IDENTITY_CACHE = ON;
GO
ALTER DATABASE SCOPED CONFIGURATION SET LEGACY_CARDINALITY_ESTIMATION = OFF;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET LEGACY_CARDINALITY_ESTIMATION = PRIMARY;
GO
ALTER DATABASE SCOPED CONFIGURATION SET MAXDOP = 0;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET MAXDOP = PRIMARY;
GO
ALTER DATABASE SCOPED CONFIGURATION SET PARAMETER_SNIFFING = ON;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET PARAMETER_SNIFFING = PRIMARY;
GO
ALTER DATABASE SCOPED CONFIGURATION SET QUERY_OPTIMIZER_HOTFIXES = OFF;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET QUERY_OPTIMIZER_HOTFIXES = PRIMARY;
GO
USE [PRX301_Project]
GO
/****** Object:  Table [dbo].[GlassType]    Script Date: 5/3/2019 7:57:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GlassType](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](500) NULL,
	[Description] [nvarchar](max) NULL,
	[Status] [int] NULL,
	[Active] [bit] NULL,
 CONSTRAINT [PK_GlassType] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Label]    Script Date: 5/3/2019 7:57:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Label](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](50) NULL,
	[Description] [nvarchar](max) NULL,
	[Image] [nvarchar](max) NULL,
	[Status] [int] NULL,
	[Active] [bit] NULL,
 CONSTRAINT [PK_Label] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[MachineType]    Script Date: 5/3/2019 7:57:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MachineType](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](500) NULL,
	[Description] [nvarchar](max) NULL,
	[Active] [bit] NULL,
 CONSTRAINT [PK_MachineType] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Order]    Script Date: 5/3/2019 7:57:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Order](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[CustomerId] [int] NULL,
	[CustomerName] [nvarchar](500) NULL,
	[Address] [nvarchar](max) NULL,
	[Phone] [nvarchar](20) NULL,
	[Email] [nvarchar](50) NULL,
	[Status] [int] NULL,
	[Note] [nvarchar](max) NULL,
	[CreateDateTime] [datetime] NULL,
	[PaidDateTime] [datetime] NULL,
 CONSTRAINT [PK_Order] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[OrderDetail]    Script Date: 5/3/2019 7:57:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[OrderDetail](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[ProductId] [int] NULL,
	[OrderId] [int] NULL,
	[Price] [float] NULL,
	[Quantity] [int] NULL,
 CONSTRAINT [PK_OrderDetail] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Origin]    Script Date: 5/3/2019 7:57:05 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Origin](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](500) NULL,
	[Status] [int] NULL,
	[Active] [bit] NULL,
 CONSTRAINT [PK_Origin] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Product]    Script Date: 5/3/2019 7:57:05 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Product](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](250) NULL,
	[Description] [nvarchar](max) NULL,
	[Image] [nvarchar](max) NULL,
	[Price] [float] NULL,
	[WireTypeId] [int] NULL,
	[GlassTypeId] [int] NULL,
	[MachineTypeId] [int] NULL,
	[LabelId] [int] NULL,
	[OriginId] [int] NULL,
	[Status] [int] NULL,
	[ProductCode] [nvarchar](max) NULL,
	[StockAmount] [int] NULL,
	[StockIn] [int] NULL,
	[StockOut] [int] NULL,
	[CategoryId] [int] NULL,
	[Active] [bit] NULL,
 CONSTRAINT [PK_Product] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ProductCategory]    Script Date: 5/3/2019 7:57:05 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ProductCategory](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](250) NOT NULL,
	[Description] [nvarchar](max) NULL,
	[Status] [int] NOT NULL,
	[Active] [bit] NOT NULL,
 CONSTRAINT [PK_ProductCategory] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Role]    Script Date: 5/3/2019 7:57:05 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Role](
	[Id] [int] NOT NULL,
	[Name] [nvarchar](50) NULL,
 CONSTRAINT [PK_Role] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[User]    Script Date: 5/3/2019 7:57:05 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[User](
	[Id] [int] NOT NULL,
	[Username] [nvarchar](50) NULL,
	[Password] [nvarchar](16) NULL,
	[LastName] [nvarchar](50) NULL,
	[MiddleName] [nvarchar](50) NULL,
	[FirstName] [nvarchar](50) NULL,
	[Phone] [nvarchar](20) NULL,
	[Email] [nvarchar](50) NULL,
	[Status] [int] NULL,
	[RoleId] [int] NULL,
 CONSTRAINT [PK_User] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[WireType]    Script Date: 5/3/2019 7:57:05 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[WireType](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](500) NULL,
	[Description] [nvarchar](max) NULL,
	[Active] [bit] NULL,
 CONSTRAINT [PK_WireType] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[GlassType] ON 

INSERT [dbo].[GlassType] ([Id], [Name], [Description], [Status], [Active]) VALUES (1, N'Bơi Lặn 121', N'Chống thấm nước', 1, 1)
INSERT [dbo].[GlassType] ([Id], [Name], [Description], [Status], [Active]) VALUES (2, N'Chronograph2', N'Kinh chronograph', 1, 1)
INSERT [dbo].[GlassType] ([Id], [Name], [Description], [Status], [Active]) VALUES (3, N'Classic', N'Phong cách cổ điển', 1, 1)
INSERT [dbo].[GlassType] ([Id], [Name], [Description], [Status], [Active]) VALUES (4, N'Luxury', N'Phong cách quý tộc', 1, 1)
INSERT [dbo].[GlassType] ([Id], [Name], [Description], [Status], [Active]) VALUES (5, N'Skeleton', N'Lộ máy', 1, 1)
INSERT [dbo].[GlassType] ([Id], [Name], [Description], [Status], [Active]) VALUES (6, N'Smart Watch', N'Công nghệ hiện đại', 1, 1)
INSERT [dbo].[GlassType] ([Id], [Name], [Description], [Status], [Active]) VALUES (7, N'Kính Bóng', N'Kính có độ bóng', 1, 1)
SET IDENTITY_INSERT [dbo].[GlassType] OFF
SET IDENTITY_INSERT [dbo].[Label] ON 

INSERT [dbo].[Label] ([Id], [Name], [Description], [Image], [Status], [Active]) VALUES (1, N'Seiko', N'thương hiệu nhật bản', N'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAOYAAADbCAMAAABOUB36AAAAhFBMVEX///8AAADt7e28vLyCgoLDw8NNTU38/PwzMzOgoKC/v7+4uLgEBARDQ0N6enrz8/NgYGDMzMzi4uKwsLDo6OiHh4fa2trv7++SkpLR0dEbGxs6OjplZWVGRkYfHx+rq6sQEBBxcXGXl5cpKSlXV1ednZ11dXUlJSUtLS01NTWMjIwdHR3WLQIhAAAHfUlEQVR4nO2aiZaiOhRFQcW0ikYGUZy1tMuy/v//HmQiZEBr6OrXa529etBM3JNckpvEIAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAODHIX/bgA9DWh//Pfs/xzM6SV5G2eF6PWTjYvmvdAwpxtfFbDa4Z0mvsxz7l0aLy3uo8bYdFTwr7TPK+nPR/wDjSV7XKV15LCdx5Shjl47MRDO6+tvLtmvN5umi1CTZOsfb0MX+d0SD4My/XOqSd2c5L1nd/tyVc6hzpq6cSNqVODI3uoLyZBe4jZa+8YzY4+JWcfntdZCO+Kd5LXP1nDzJJCAkcHYh64ChK6dT5rSxunC0W1u9PjhHkp4e2Hrk/31OZkXbHNF/QmZs14mkz7lk7og0u8OvNoXptySgzi7VLRLM6/Irf34rQ2RN6id0jWZsN6PLbLLEp6nIy4ftdIODJVNTOVwcojLN8zTJVvO1WZXJlH3oVdhm8ty72WpNOW3kqPaLzz2FZt38GhW1zZPBW9PawPDaayg6fxsZ81OabY+WzHQcVSRigOZJ5OFNk1mylGTDk2a8AJ+DWWvRC89ZsS9jNYUsqy9v8umvGcst2TAVtdGsb6YZ1UwuZlKNoZOKR2zKwMEymzZ9PdcyFjzJ7LOGqSZTINxmZBd+M4ZRoVwzvOR68loM2npiLh35lguNw7vutxEXMaW++GF8c8kciJH5Hpm/eM7YTO8rT1oFalIhAXkTJp2oY4kcSxfUn33nNZxjyaEX3WmflEm+QSYZSJHrRE9W84OmXSfdc01HLSg6saS9X2Wlc/9XZOa8icq8S68lpxDpZ58Dpnte4NQU4EP1q0MlkS/iT8okwSSUKs/GmAnv+u03uRDDXaqKfMo8dsTpJGiioC6ZlBJa8U0yF9Jhj5GhsuTpe2q20mXxgvvxuH6zfdWekpkKs9gLQb4kk0iHrbhYEeqMW9z3qqyZ8kJqeha+8ZL7qxDaY+gPfCCz2jpw9C5/fjT7ahFbGb1ffeXL4q5DY70VMZ61FNbts45K9kenzFiT6eBpmY3DJnZsKgJdR3iuQ2/cF0yDw/B9NilySkzXtRL0Wo7R9G6DnpNJtJBg52qr3hXGdW92b/u5gWvlTbQVT+5vm+l0Oqy5bE+Da790v+lC5rZMJBPhZ1+UGURHEcZVRpaWFhKcWNbm0XGIiCwKlcBm31j9Y7FZJHaLXKarwtdkshm2aTY1S5JgxzJOj2SKNUWLH4uNV6LgdjCjqoG37JdkMoeNm83ZrWe9nHwDcO/UWNHjTerzMTkfwwfcyh+QGSV8e6V1+c6caQkP81ePZFLeUHtipZPt3mt4zP60K/wRmcNQ7LLfk7588twsy1dU/9ZIkIues+SXh8HlzdpLN33bqvFHZErqTddIfhkYcz1vxVJvImKlxJ1L6DJPBWXSPwyas4iY2OvmpT+RSLu+LvPOVjG1eBoh7Ywlvjyagg68shn1eGO9fPQudF5tmZrv5N8k88hXz3rvxB/bel1UuFo8kMlj9Rd/4GuxHPLJb6o1/Cg8aIo2n56SuVP9T+rHxsLzZCtErhQP5iAR3J1UY+Oafr8r3l++Wx7wMKZNeLu60zwjU18o6EbOC63zyF/8MLZ7nK68qto50FC15JOptuvaEcPDHYo435p8aDTj9rYj34uZd98McX2EyhScu1Qu17yQFetZ8YaOiJy0udaWSXKO+PaZjdgwN144uT0ON7QJruUkkHa8naeQRRkLlUBFZOCZeVsytTJ/5PQgsgxXJ7UXzW0XSrpPJ5tmq7WheWW4TF24g5Xl2E6Z4pbqKzJNwzPhzfWRiMzrHflYXXwq5YHguWlPjmb94rmrkYC+8mdpW8mfONljnOW5szYOYxGz7Bx7W8LGkmdreoTMaoRdD+GII3Z9w/5jMkU40K4n017tA+yA/paBmz7d0CZqn7sPa4tdyCvqG/aHp+67j8j0nrrXnKR9ohfqXxiww716lE/GCkGytbC2/aZTfXOyuxaG41J5WxKHR1q7+ng2qFiII6XpYuDhVckkwYGlLMQ1xoXVmbE+HfEccVcwZ99mahRS9qyZHJ2YZbPOrnSK0CGcR2rVIMVKvF6x6RrU2IPd5vesTHuELNNyctavxSatW8W4c4OqV/LciGXamLfpvMZlQXsVmWqXifFwcD0cRqvtTaVYnqHLdFouE0UEbVzjetTKrvbeb8b6bTUvrOqYMmPNsJjvTQi/yfNaOzUXVRqbRdxVR+K9+PilvHlbLXjuUt60KW62YCU79DD7mX2/W2uGlJmcHVtNxUW96V+/lBd88rcHUmYtJHtxPvPkiOiWKtij0enVWS3eJrLhz/z24Ht/YhFuhcyKgEysBl4XqfPQVRyPswxajrZGD20G/dYOUpzAPwvx1mE5S28Ok+LKNXYmaXZqLB6uHIeQHmgaZaPz+Tw69Mv0n/ipF02LKCqLzt946RDXmXvHHdL/gv+3dQAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA3/ARCCZcb4l8b+AAAAAElFTkSuQmCC', 1, 1)
INSERT [dbo].[Label] ([Id], [Name], [Description], [Image], [Status], [Active]) VALUES (2, N'Citizen', N'thương hiệu nhật bản', N'https://www.citizenwatch.com/on/demandware.static/Sites-citizen_US-Site/-/default/images/opinionlab/logo.png', 1, 1)
INSERT [dbo].[Label] ([Id], [Name], [Description], [Image], [Status], [Active]) VALUES (3, N'Tissot', N'thương hiệu Thụy Sỹ', N'https://botw-pd.s3.amazonaws.com/styles/logo-thumbnail/s3/0001/2182/brand.gif?itok=-K7WHWOp', 1, 1)
INSERT [dbo].[Label] ([Id], [Name], [Description], [Image], [Status], [Active]) VALUES (4, N'Rolex', N'thương hiệu Thụy Sỹ', N'https://assets.sandsresortsmacao.cn/content/dam/macao/venetianmacao/master/main/home/shopping/shop-assets/master/rolex-logo.png', 1, 1)
INSERT [dbo].[Label] ([Id], [Name], [Description], [Image], [Status], [Active]) VALUES (5, N'Phillip Pattek', N'thương hiệu đại gia', N'data:image/png;base64,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', 1, 1)
INSERT [dbo].[Label] ([Id], [Name], [Description], [Image], [Status], [Active]) VALUES (6, N'Iwatch', N'thương hiệu Trái Táo', N'data:image/png;base64,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', 1, 1)
INSERT [dbo].[Label] ([Id], [Name], [Description], [Image], [Status], [Active]) VALUES (7, N'Casio', N'Thương hiệu nhật bản', N'https://m.media-amazon.com/images/S/aplus-media/sota/dc36de03-143a-4a15-bf1d-015e51d8e7fc._SR300,300_.jpg', 1, 0)
SET IDENTITY_INSERT [dbo].[Label] OFF
SET IDENTITY_INSERT [dbo].[MachineType] ON 

INSERT [dbo].[MachineType] ([Id], [Name], [Description], [Active]) VALUES (1, N'đồng hồ cơ', N'Chạy bằng cơ học', 1)
INSERT [dbo].[MachineType] ([Id], [Name], [Description], [Active]) VALUES (2, N'đồng hồ điện tử ', N'chạy bằng điện tử', 1)
INSERT [dbo].[MachineType] ([Id], [Name], [Description], [Active]) VALUES (3, N'Solar', N'chạy bằng năng lượng mặt trời', 1)
SET IDENTITY_INSERT [dbo].[MachineType] OFF
SET IDENTITY_INSERT [dbo].[Origin] ON 

INSERT [dbo].[Origin] ([Id], [Name], [Status], [Active]) VALUES (1, N'Thụy Sĩ', 1, 1)
INSERT [dbo].[Origin] ([Id], [Name], [Status], [Active]) VALUES (2, N'Mỹ', 1, 1)
INSERT [dbo].[Origin] ([Id], [Name], [Status], [Active]) VALUES (3, N'Nhật Bản', 1, 1)
SET IDENTITY_INSERT [dbo].[Origin] OFF
SET IDENTITY_INSERT [dbo].[Product] ON 

INSERT [dbo].[Product] ([Id], [Name], [Description], [Image], [Price], [WireTypeId], [GlassTypeId], [MachineTypeId], [LabelId], [OriginId], [Status], [ProductCode], [StockAmount], [StockIn], [StockOut], [CategoryId], [Active]) VALUES (1, N'ĐỒNG HỒ SEIKO SRZ397P1', N'ĐỒNG HỒ SEIKO SRZ397P1', N'http://cititime.com.vn/vnt_upload/product/12_2016/Seiko/Seiko-SRZ397P1.png', 7360000, 2, 1, 1, 1, 2, 1, N'AAA', 20, 40, 20, 1, 1)
INSERT [dbo].[Product] ([Id], [Name], [Description], [Image], [Price], [WireTypeId], [GlassTypeId], [MachineTypeId], [LabelId], [OriginId], [Status], [ProductCode], [StockAmount], [StockIn], [StockOut], [CategoryId], [Active]) VALUES (2, N'ĐỒNG HỒ SEIKO SSC355P1', N'ĐỒNG HỒ SEIKO SSC355P1', N'http://cititime.com.vn/vnt_upload/product/12_2016/Seiko/seiko-ssc355p1.png', 13915000, 2, 1, 1, 1, 2, 1, N'BBBB', 20, 40, 20, 1, 0)
INSERT [dbo].[Product] ([Id], [Name], [Description], [Image], [Price], [WireTypeId], [GlassTypeId], [MachineTypeId], [LabelId], [OriginId], [Status], [ProductCode], [StockAmount], [StockIn], [StockOut], [CategoryId], [Active]) VALUES (3, N'ĐỒNG HỒ PATEK PHILIPPE 5372P', N'ĐỒNG HỒ PATEK PHILIPPE 5372P', N'http://cititime.com.vn/vnt_upload/product/brand/PP/Patek_Philippe_5207R.jpg', 11212410000, 2, 1, 1, 4, 1, 1, N'5372P', 20, 40, 20, 1, 1)
INSERT [dbo].[Product] ([Id], [Name], [Description], [Image], [Price], [WireTypeId], [GlassTypeId], [MachineTypeId], [LabelId], [OriginId], [Status], [ProductCode], [StockAmount], [StockIn], [StockOut], [CategoryId], [Active]) VALUES (4, N'ĐỒNG HỒ PATEK PHILIPPE 5320G', N'ĐỒNG HỒ PATEK PHILIPPE 5320G', N'http://cititime.com.vn/vnt_upload/product/brand/PP/Patek_Philippe_5207R.jpg', 1812360000, 2, 1, 1, 4, 1, 1, N'5320G', 20, 40, 20, 1, 1)
INSERT [dbo].[Product] ([Id], [Name], [Description], [Image], [Price], [WireTypeId], [GlassTypeId], [MachineTypeId], [LabelId], [OriginId], [Status], [ProductCode], [StockAmount], [StockIn], [StockOut], [CategoryId], [Active]) VALUES (5, N'ĐỒNG HỒ PATEK PHILIPPE 5316P', N'ĐỒNG HỒ PATEK PHILIPPE 5316P', N'http://cititime.com.vn/vnt_upload/product/10_2016/Patek/Grand-Complications/Patek-5073R-001.png', 17793000000, 2, 1, 1, 4, 1, 1, N'5316P', 20, 40, 20, 1, 1)
INSERT [dbo].[Product] ([Id], [Name], [Description], [Image], [Price], [WireTypeId], [GlassTypeId], [MachineTypeId], [LabelId], [OriginId], [Status], [ProductCode], [StockAmount], [StockIn], [StockOut], [CategoryId], [Active]) VALUES (7, N'ĐỒNG HỒ TISSOT T085.410.11.011.00', N'ĐỒNG HỒ TISSOT T085.410.11.011.00', N'https://donghoduyanh.com/upload/images/TISSOT%20CARSON%20T085.410.11.011.00.jpg', 9070000, 4, 1, 1, 3, 1, 1, N'T085.410.11.011.00', 20, 40, 20, 1, 1)
INSERT [dbo].[Product] ([Id], [Name], [Description], [Image], [Price], [WireTypeId], [GlassTypeId], [MachineTypeId], [LabelId], [OriginId], [Status], [ProductCode], [StockAmount], [StockIn], [StockOut], [CategoryId], [Active]) VALUES (8, N'ĐỒNG HỒ TISSOT T084.210.11.116.01', N'ĐỒNG HỒ TISSOT', N'data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBxITEhUSEhMWFhUXFxsVFRcWGRgXFRoaGBMYHRoXExgYHSggGBolGxcXITEiKCkrLi4uGSAzODMsNygtLi0BCgoKDg0OFxAQFy0eFyUrKy0uNy0wLS0rLTctLTAuLy0tLSsvKzUrLS0tLSstKystNysrLS0tKy0tLS0rLS8rK//AABEIAOQA3QMBIgACEQEDEQH/xAAbAAEAAwEBAQEAAAAAAAAAAAAABAUGAwIHAf/EAEcQAAIBAgMFBQQFCQYFBQAAAAECAAMRBBIhBTFBUWEGEyJxgTJCkaEUI1JisQczcoKSssHR8BVTc4Oi8WTS1OHiFhckQ8L/xAAXAQEBAQEAAAAAAAAAAAAAAAAAAQID/8QAIBEBAQEBAAEDBQAAAAAAAAAAAAERAjESIWETUXGh8P/aAAwDAQACEQMRAD8A+4xEQEREBERAREQErNsbew+GsK1SzEXVACzkcwq6267pZzN9odmBqwrAAnIFZTxAZiMp4HxHoekCBifygIASmGqEDi5WmPlmPynPZvbDGYk/UYRLfaaqbfug/Ke8bs7DVabUqv1YbTx+Djplf2Sb8jO+w9h1MNbIRVTgb2a3oLH5Qr3jNs4qiVGJfC4cMCVP1lW5UrdSCUt7V73M5/8AqX/jcKf8lv8AqJC7dsKrUUfBrXIDtkqhcouUGYGza8OG8zI18Eg3bIw3ohP7tOB9D+n7Tyh1oYZwQCMtVwSCNPaWw+MqqnbuvTfJWwYVulTf5eEg/GX2ytos9Cl3dFyO7UAtZBooHMn5Sq2jshGcVMS6LY3VSwAvw1OrHygSMJ25oNpUp1aXUrmX4pc/KaXDYhKih0YMp1DKbg+RmVfDK2iU/wBZlKr6A2ZvhbrNDsbDLToqi7hc+ZLEk/EwidERAREQEREBERAREQEREBERAREQEREBOGJwwfoZ3nPEV1RS7sFVRdmJsABvJJ3QM12g2ZjnpZMLWFF73zAKcwtot2Vsg5nKZC2fsqquHT6WlP6Rr3lTD5qQbxGxLIEJbLa+gF72E/cd2sr1iVwVOy7u+qA69aacurfCVVbZFSpY4vEO9/dZjlPRaa2X4CFaXZOFojE+Cq9Q9ycwes1YIc62tnYlSdfO3SaIU15D4T5htN6mzspwopUDV8PeV0ZkKrckKtM5g12X2raXkB+1m0agsdp4OkDpmp4aqzDqA9xeEaijsql3VMirXct7Sd/Vyqd5UIjAADlaR9p7A2ga6fQXpYahkBcqi98Xub5s9Ns62tpmXjeQcPsCgaSViGTMocVW0uGFw5ZT4b3vrY6ydSbH0NaVc1U+zV+sB8m9r5wrT4TZ9YkGqyiw1tvJtqbbl+JlxTQAWEz2we1SVnFGsho1uCk3R/8ADbS5+6bHzteaOEIiICIiAiIgIiICIiAiIgIiICIiAiIgJmu0WHOIqLSY/VU7Mw+053BuYUWPmegmllRb6+qpH2WXqClvjdX+ECurqKVMlVGlgo4XJAF+lyJ22bsMn6yoTc/tH/lHSTMRh7i3G4IvuupBF/UCWGGxAcciN6neP5jrCoe0tmGplysq5QR4lzb7dRbdK9uzrH3qJ86X/lLjG7Qp0iocm7XIABOi2vu/SHxkb+3KP3v2TCO39nDu1p3tlUKCosNBbQcB0mfq4F8M4t+bZgCB7N2Ngyj3Tci443J3zU4esHVXXcwDDhoRIe0GD2QagEFjw8JuAOtwPhApNpbISqLMLEagjQgjcVI3EHjLjs9i2qUR3hu6M1JzzKMRm9RZvWVHaXb1LBouYZ61Q5aFBfzlV+AA4KOLHQD0EmdisLUp4fLWN6hqO9QjcXdsz5b+6HLKOiiBfREQEREBERAREQEREBERAREQEREBERASPiqAbW3Q/iPUHdJEQM9jdr/RyO/VmpHQVVFyvSqo4feA9JY4OvRrAPSqK4+0hBt0NtQek49ouz9HGUjSrA2vcFWKsCNxBUjnMlh+xaYUDvGZwt/r8/d1wvV0ysbesDTbRps2KpIbFe5qsOdxUoA+molNtztHs7CA9/iaQYC+RWD1PLItz8ZU7d7PVMUO5weKr5alJqdWvWeo601NWg1qbNbOWFNlIU631Mj7D/Ins2iVas9XEMCDZiEpm3NVFyOhYwL3ZvbDBU8FSfFYulTbJ4qWYZ1I0KlFu7EbjpM5tD8pFfE/V7KwxCnQYrEgrSH+FTFzUPQXP3TLel2FwCVatetRZ6z1HclkzU9XJUo2UhRbLxFp2odgqOIqriK1V2VQAtKnU+ruDvqFdWPC1yIHrsb2Q7lzisQ74jGVB4q1Xeo+zTXdTXoPluG5poALD+uZinTCiwFp6gIiICIiAiIgIiICIiAiIgIiICIiAiIgJzrVgo19BxPkJ4xeJCWFrs2irz6nkBxP8SBODZaatWruoCgs7sQqqo1Op0VR/veB2GZt/hHIb/Vv5fGZ3auIw9Cs71SgsqFS5GntXYZuJ579JRbU7T4nGKThX+h4K9vpjrevW11XBUjwP2zz03TLV+xdGoR4ajgE2qYkmriCCbnMosurEnxC+unUNPifym4HNlWt3jcqSvVP+hSJ4/8AcFN/0fF25/Rqtv3ZHwexe5UBC4X9PIOgsgv85JOEIIAZrkXH1tUHUaWu2pOsuU17wn5S8EWytXFNuVVXpH/WBNJsHEpXrVqikMMtIBlN+FTcw9Jl69BnQrUu6nhUCVk+Di/znrstWp4HvBToqKdRg790LZSFAv3fuiw4Rg+gPVZN4zDp7Q/g3yPnO1GsrjMpuP60PI9JFwWNp1kD02DKeI/A8jPFaiyt3lPfxHBhybryPDqNJBYxOWGrh1zDyIO8HiD1nWAiIgIiICIiAiIgIiICIiAiIgJzxFdUVnY2VRc+nLmek6SBi17yqlP3UtVfqbnux1FwzdCi84DBUjrWq6OwvY7kUbkv03k8TfhaYTbWLGPIq1gTgVe2Fw+44x1P5+t/w4IuqnQ2zHQqJpe1biqRgybU2U1cWeVAG3dnl3rAr+itTjaV2zsMa5OJcWUjLSXcEpj2QBwuLE+g4SiPhtn1Kz56jeK1gQNEH2KK+6OF95mhoYBUQC27+tZ0wAtqfKd8SpAJuLcBNeEUe1qaimWNgFZTc7haoshV3pjKMyK2VCSWAtoCpAJ6A+ijys6e1KDAha1I7y3jU2sCdddNAT6GKm0aOX87T9nMPEuqjew19nQ69IxNftGgCi21Xgd+luc4YvZanUaHmJJwe0aLEIKtMswuqh1JI5gA3IkmqbXPAaSjLhKuHfvKejcRuSoOTDg3WbHY+00xFPMunBlPtKw3q0qKoD+C3UjkLaX5HpKqnVOFrir7hstXqt7B/NTv6TFjTU4ljRbvB7J0qDp9odR+F+ktQb6icWUOsibFYqGon/6z4f0D7Pw1X9USCyiIgIiICIiAiIgIiICIiAiIgJDwAvnf7bk+g8K29FB9TJVV7AnkCfgJDwzZaY6KPksDK7Scurnjiq5X/Jo3UAfdYIT/AJxl1mCqFHAcPn8ZRqlqtBP7vDrbzNv+STmqAi19eXH/ALjrNcxKssPc2ymwvr/CcG2gtZTlvdWIZT7QsfeHz9ZzwFext8ZF2lRDPnBKOPfX8G+0Oh9LS0+HHaOxaTUqjWYjM+IyjKbscKaRUZgQQVJOo39NJmsTgUvfJX8DPqWFyUr2UjwEsL1SwVrjwgam81eD2x4hTq2V72De4/lyPT8d8/O0W2LU+7psO8c5dDfKOLfwHnGmOOyzRVmcM5en3qMTbKzVqiO+Ww1OZANOR375MRnqkkaLffwHlzbruErez+ybrc3CDcOLfyHXefnNKq2FgLAaADdblIOeFRVGUDT5k8yeJlftrCgprrbQ+R0Msstres54zI4yBgWsbi+v9ayjz2RxRaiFY3amTTP6p0PquU+sn1fBXRuDgofO2YH/AEkfrTP9lalqlZf8N/UqVP7kte0jkUS63zIyMLWB0qLexOm64mFXcTLdjttVqtStRxBUstqlLcH7pmdLVbaF1em4uNCCs1MBERAREQEREBERAREQEREDjjB9W/6LfgZVnEgqOqj5iXUyVW6qB9kZP2Dl/hAgMb1lPOglvRj/ADk5qjGmoNjk3cWOliSfWVHea02+yz0W9TdPll+MmhjmCH49JYVNAAswnB6t/wAZ7scov6+c4MvhJ42m2ULFAMjAm2+xPAjUH42kPYODqhy3dm7WOYkZBxzLx5ct07hMzAcN58uHxPyB5iX9HRRMz3atdMPVKEr5n4STTri2/jrK7Ekhgek/Eq7/AElJNWnfb+gnJaDgqS4KIpygA5ibEeNr2Isd1pwovf1Fp0xuJtSPMjKPWRFTsF7Vap+7TH75/wD0PjJ/aPFD6JXOptTOguCeikEEHyI8xKDZFa71WG66qPQH8UFI/rTRYKmHKqwBDMLg6iy+LUHqomWmc/Jlh6tWvVxjKUpin3NPM7MznvqjMxzMxFiStiTuB4z6TPNNAoAUAAbgBYDyE9QhERAREQEREBERAREQEREBM/tfD2dvveIfIMB62P600Ei7QoFluBdl1A5819R87QPn2LXJVyHRawyg8qqAlf2lBH+WOcl0AXKvuYeFhyI3y025sZMRRIBIDAFWHtKwN1db7mVgCOomY2RtB+8enVAXEUrCsg0FRfdr0uaMPgbg7oW+7ThSy9TOWNSwCjUnQden9cpZbNy1ACh048x0kWlh2Na9RbXYhRvsoB4jif63zozmK/DYbK4B4nXztw6cPSWyKB+E9YnC+NeP+xIgEXC3GblfXztyjmJdQsSeH9b5+NT+U91hx+9b4yQ1Ow+F5MWVEw9SxsZWbe2gFQ62AB1GpAAuzAcbLu5kqOM646uFJ88otqSeAUcWlHs+i2Lq5tDRRhqNVd0a4VDxpowzFvee1tEF81Ys9h4VggzCzHxMN9ifdvxyrlQHkgmt2HR8TN9kZB5mxb5ZfiZGpYXu1va7E5UXmx3Dy4k8ACeEu8Fhu7QJe5GpPNibsfUkmRXeIiEIiICIiAiIgIiICIiAiIgIiIFfWp90xe16bG7j7JO9x908eR15yk7Wdk1xSrUpOaWIp60ay6lSfdYe/TPFZq5Bei9PWkMy8aeg9aZOg/ROnUcQ+YYHtJUw9YUMaowmJ91if/i19bZqLnQX08J3Xtv0m3w220JHfLla2/eD1lhj8DhMdSalWprVX3kcWZT5GzI3Ii3SfPsf2H+i1EoYXGVqSMSaavkqgMwOWmM49kCmxA33O+FbR8zvmp4kWNiAwVl36gbiOXxng4WoRlDU1yElX3kkg+0DwuxO/W0xx2XtSnxwtbqy1KTHzKs0/O52mdPo+GHX6RXI+GSXRpa9EIcz17i508KrvB1tytYa8+cg7e7W0qaMxZUXdmY21IOigXZybHRQ246iVabC2i51rYej1pUS9T0eqxH+mSthdjimPpvWrVcQBTaoO+KtkcNlvTAAC6OdAItTEDZuycTjzmqK9DDHg3gr1lO9coP1FI8Rcu3E2M+h4PZ9LD0xoFVQAABYAbgFA9AAJLq4lEORRmf7C6t5twUdTaKOFYsKlUgsPZUewnlf2m4Zj6AXN4GEoknvHFjayL9hTz++ePLcOJMyIgIiICIiAiIgIiICIiAiIgIiICIiAiIgcMTg0exYeIbmBKuPJhqJie3H0ZkelXqPWuqjKhCVaZRyyVFqrYKwPMayw7YbaqWOGwpbvnFhkALAX1Yk6Iu8ZjfXcDa0zmx/yb+H6521JYojMBmO9ncnPUb7xPpCqrZvbh8MrBqj4ylTXOy1afdYtaYKgstRSaVfLmBIOVra8JuuzHarAY8D6NXUva5pN4Ko53Q6m3MXHWRNn9icLQqq3dqQ4qUnBA8SvSbMrcwQNRMF2w/IuaZOJ2VVYMvjFFmIcEa/UVd9+QbX70I3e3O3WFw1d8NlZ6lPKHJ8FNSyhguY7zZlO62u+SNnbWo4moneuaLkFVRWyq4JB0f2idButM1s3sXh9po2OqmolesKTGpTco4P0OhcW3HW5sRxlF2g7L4vADNWQYzCKQ3eIpFWkQdHemp8JW/5xOtwRpA+24fDpTGVFCjfpxPEnmes6zJdhdvpWoU1701RYAO1s55ZioAN7HUAagiwNwNbAREQEREBERAREQEREBERAREQEREBERASNtCqVTw+0xyqOp/on0kmR6rDOoPJiPPQfgT8YHHZ2zEpA2F2bV2O9j/LkOAn6m0UZnp0jndDlcD2VNr2dtwOo01Ou6eNu12TD1WQ2bKQp4gnQEeV7zrsrAJQpLSpgBVHDiTqzHmSSST1gRdoYdgUqHM7BrAKDlUFTchRx3C5vvO65ngVKn2G+BlxECi7N7OelSb3CajkKdxXNZLjepygbulwZbUq4JyMMrWvY8RzU8R/2uBed5E2ol6ZYaMnjQ8mH8DqD0JgYLtF2fGzqrbQwi2w5JOMoL7KA2viaIG61hnUaEC9rqLb/Z2JFSklQG4YXvOqkOoJGjDceRG4yi7G4buUrYYexQrlKXSm1NKiL+qKmX9WBoYiICIiAiIgIiICIiAiIgIiICIiAiIgJB2rTbKHQXZDe3EqfaA67j5iTogVLVExFJkv4XUqbbxcbx1Ej7P23l+qxHhqrv5N9+l9pTvtvGo4SRtHZftVKRytqxUeyx8uBPMT56mMqvRo4rEvVqU6jXyKqNQF2yhDxU3sL3vpN88Xpqc6+nU9pUWFxVQi9vaG/kRwM/fp9L+8T4ifJO0Y+j1lrYLvlqFXRxSIqGxykAZzceIC+u4H1/KvavHvRZlGKAWwapkw4pA5gDqPGBe4GnnNfR6yX7sc9c9XJ1Lfy+wHEpYHMtju1Gvlzlfia/ffV0/YOjvwtxCnix3dPgJ85WgUwWJxFXP9KZqpOYgZSKxFsq+EnTXeL3tpNXtrHVlwdV6YZctEsHAygWXeL7/SYnO583GsaHHY5aSEncBuGpPIADeeAE8bBwrpTZqgtUquatQciwAVOuVFRb8ct5QdisLUY95XGJLZQVNfu+7ueNIISb9TwM2Mdc+m4WYRETKEREBERAREQEREBERAREQEREBERATy7WF56kXaZfun7tcz28K3tcwIWLxlUhu7AuASq3tmNtAWI8NzxtMP2fwad5Uq42jh6b95np06TNUPMtUpo7rmvuIA8hJmO7QUKRtiqOJvxzYes1P0yrkMidnu2ff1GQ5KVMMQoSwut9C19QTysLSzqzxVi1/tbBrilrCiyVQtQMzIyBj7qDMLZn37vOSKlbZ7fSKIWmQ5zvd2AqNmDNYi5WzWOmhMgdqKlHJTcrcmt4irAsctGoFF3B5LqOA3ygONw9hahX36/WUzod9rJOnqv9SSLjZJw5ovTTZ9QrUJ7wgliU7xwhQ3zHQHlulVTw7d7lw5p08NWpgVqdcVabHUg2d/aFm0ym00OyMfhmoUWyliKa+JScxsoNmC2uQbi2uo+FXiu09WjUXJh69SnbKVShVqMByUhLbwN8Xq55/bWr/s9s1cLUJpoLMMuYlict72BJItoOE2Anz7BbRxFb8xs7EUidc1RVop+upbX4Xn0BL2F9/Gc7bfes2v2IiRCIiAiIgIiICIiAiIgIiICIiAiIgIiICflp+xA51KKtoyg+YB/GeRhKf92n7I/lEQOqqALAWA3Abp+xEBERAREQEREBERAREQERED/9k=', 10980000, 4, 1, 1, 3, 1, 1, N'T084.210.11.116.01', 20, 40, 20, 1, 1)
INSERT [dbo].[Product] ([Id], [Name], [Description], [Image], [Price], [WireTypeId], [GlassTypeId], [MachineTypeId], [LabelId], [OriginId], [Status], [ProductCode], [StockAmount], [StockIn], [StockOut], [CategoryId], [Active]) VALUES (9, N'ĐỒNG HỒ CITIZEN BI5006-81P', N'ĐỒNG HỒ CITIZEN BI5006-81P', N'https://donghotantan.vn/wp-content/uploads/2018/06/dong-ho-citizen-BI5006-81P-1.jpg', 2900000, 4, 1, 1, 2, 2, 1, N'BI5006-81P', 20, 40, 20, 1, 1)
INSERT [dbo].[Product] ([Id], [Name], [Description], [Image], [Price], [WireTypeId], [GlassTypeId], [MachineTypeId], [LabelId], [OriginId], [Status], [ProductCode], [StockAmount], [StockIn], [StockOut], [CategoryId], [Active]) VALUES (10, N'Đồng Hồ Citizen BI1052-85P', N'Đồng Hồ Citizen BI1052-85P', N'https://donghotantan.vn/wp-content/uploads/2017/10/dong-ho-citizen-BI1052-85P.jpg', 3400000, 4, 1, 1, 2, 2, 1, N'BI1052-85P', 20, 40, 20, 1, 1)
INSERT [dbo].[Product] ([Id], [Name], [Description], [Image], [Price], [WireTypeId], [GlassTypeId], [MachineTypeId], [LabelId], [OriginId], [Status], [ProductCode], [StockAmount], [StockIn], [StockOut], [CategoryId], [Active]) VALUES (11, N'ĐỒNG HỒ CITIZEN BJ6501-28A', N'ĐĐỒNG HỒ CITIZEN BJ6501-28A', N'ĐỒNG HỒ CITIZEN BJ6501-28A', 4700000, 2, 1, 1, 2, 2, 1, N'BI1052-85P', 20, 40, 20, 1, 1)
INSERT [dbo].[Product] ([Id], [Name], [Description], [Image], [Price], [WireTypeId], [GlassTypeId], [MachineTypeId], [LabelId], [OriginId], [Status], [ProductCode], [StockAmount], [StockIn], [StockOut], [CategoryId], [Active]) VALUES (12, N'ĐỒNG HỒ CITIZEN BJ6501-10L', N'ĐỒNG HỒ CITIZEN BJ6501-10L', N'https://donghotantan.vn/wp-content/uploads/2018/03/dong-ho-citizen-BJ6501-10L.jpg', 4700000, 2, 1, 1, 2, 2, 1, N'BJ6501-10L', 20, 40, 20, 1, 1)
INSERT [dbo].[Product] ([Id], [Name], [Description], [Image], [Price], [WireTypeId], [GlassTypeId], [MachineTypeId], [LabelId], [OriginId], [Status], [ProductCode], [StockAmount], [StockIn], [StockOut], [CategoryId], [Active]) VALUES (13, N'ĐỒNG HỒ CITIZEN BJ6501-01E', N'ĐỒNG HỒ CITIZEN BJ6501-01E', N'https://donghoduyanh.com/upload/images/dong-ho-citizen-bj6501-01e_8.jpg', 4700000, 2, 1, 1, 2, 2, 1, N'BJ6501-01E', 20, 40, 20, 1, 1)
INSERT [dbo].[Product] ([Id], [Name], [Description], [Image], [Price], [WireTypeId], [GlassTypeId], [MachineTypeId], [LabelId], [OriginId], [Status], [ProductCode], [StockAmount], [StockIn], [StockOut], [CategoryId], [Active]) VALUES (14, N'ĐỒNG HỒ SEIKO SXDG58P1', N'ĐỒNG HỒ SEIKO SXDG58P1', N'data:image/jpeg;base64,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', 14950000, 2, 1, 1, 1, 2, 1, N'SXDG58P1', 20, 40, 20, 1, 1)
INSERT [dbo].[Product] ([Id], [Name], [Description], [Image], [Price], [WireTypeId], [GlassTypeId], [MachineTypeId], [LabelId], [OriginId], [Status], [ProductCode], [StockAmount], [StockIn], [StockOut], [CategoryId], [Active]) VALUES (15, N'ĐỒNG HỒ SEIKO SUR138P1', N'ĐỒNG HỒ SEIKO SUR138P1', N'https://cdn3.dhht.vn/wp-content/uploads/2015/10/64_SUR138P1.jpg', 5980000, 2, 1, 1, 1, 2, 1, N'SUR138P1', 20, 40, 20, 1, 1)
SET IDENTITY_INSERT [dbo].[Product] OFF
SET IDENTITY_INSERT [dbo].[ProductCategory] ON 

INSERT [dbo].[ProductCategory] ([Id], [Name], [Description], [Status], [Active]) VALUES (1, N'Đồng Hồ', N'Đây là đồng hồ', 1, 0)
INSERT [dbo].[ProductCategory] ([Id], [Name], [Description], [Status], [Active]) VALUES (2, N'Vòng tay', N'Đây là vòng tay', 1, 1)
SET IDENTITY_INSERT [dbo].[ProductCategory] OFF
SET IDENTITY_INSERT [dbo].[WireType] ON 

INSERT [dbo].[WireType] ([Id], [Name], [Description], [Active]) VALUES (1, N'Ceramic', N'dây bằng ceramic', 1)
INSERT [dbo].[WireType] ([Id], [Name], [Description], [Active]) VALUES (2, N'Dây da', N'dây bằng da', 1)
INSERT [dbo].[WireType] ([Id], [Name], [Description], [Active]) VALUES (3, N'Dây dù', N'dây bằng dù', 1)
INSERT [dbo].[WireType] ([Id], [Name], [Description], [Active]) VALUES (4, N'Dây kim lọai', N'dây bằng kim loại', 1)
INSERT [dbo].[WireType] ([Id], [Name], [Description], [Active]) VALUES (5, N'Thép không gỉ', N'dây bằng thép', 1)
INSERT [dbo].[WireType] ([Id], [Name], [Description], [Active]) VALUES (6, N'Titanium', N'dây bằng titanium', 1)
SET IDENTITY_INSERT [dbo].[WireType] OFF
ALTER TABLE [dbo].[Order]  WITH CHECK ADD  CONSTRAINT [FK_Order_User] FOREIGN KEY([CustomerId])
REFERENCES [dbo].[User] ([Id])
GO
ALTER TABLE [dbo].[Order] CHECK CONSTRAINT [FK_Order_User]
GO
ALTER TABLE [dbo].[OrderDetail]  WITH CHECK ADD  CONSTRAINT [FK_OrderDetail_Order] FOREIGN KEY([OrderId])
REFERENCES [dbo].[Order] ([Id])
GO
ALTER TABLE [dbo].[OrderDetail] CHECK CONSTRAINT [FK_OrderDetail_Order]
GO
ALTER TABLE [dbo].[OrderDetail]  WITH CHECK ADD  CONSTRAINT [FK_OrderDetail_Product] FOREIGN KEY([ProductId])
REFERENCES [dbo].[Product] ([Id])
GO
ALTER TABLE [dbo].[OrderDetail] CHECK CONSTRAINT [FK_OrderDetail_Product]
GO
ALTER TABLE [dbo].[Product]  WITH CHECK ADD  CONSTRAINT [FK_Product_GlassType] FOREIGN KEY([GlassTypeId])
REFERENCES [dbo].[GlassType] ([Id])
GO
ALTER TABLE [dbo].[Product] CHECK CONSTRAINT [FK_Product_GlassType]
GO
ALTER TABLE [dbo].[Product]  WITH CHECK ADD  CONSTRAINT [FK_Product_Label] FOREIGN KEY([LabelId])
REFERENCES [dbo].[Label] ([Id])
GO
ALTER TABLE [dbo].[Product] CHECK CONSTRAINT [FK_Product_Label]
GO
ALTER TABLE [dbo].[Product]  WITH CHECK ADD  CONSTRAINT [FK_Product_MachineType] FOREIGN KEY([MachineTypeId])
REFERENCES [dbo].[MachineType] ([Id])
GO
ALTER TABLE [dbo].[Product] CHECK CONSTRAINT [FK_Product_MachineType]
GO
ALTER TABLE [dbo].[Product]  WITH CHECK ADD  CONSTRAINT [FK_Product_Origin] FOREIGN KEY([OriginId])
REFERENCES [dbo].[Origin] ([Id])
GO
ALTER TABLE [dbo].[Product] CHECK CONSTRAINT [FK_Product_Origin]
GO
ALTER TABLE [dbo].[Product]  WITH CHECK ADD  CONSTRAINT [FK_Product_ProductCategory] FOREIGN KEY([CategoryId])
REFERENCES [dbo].[ProductCategory] ([Id])
GO
ALTER TABLE [dbo].[Product] CHECK CONSTRAINT [FK_Product_ProductCategory]
GO
ALTER TABLE [dbo].[Product]  WITH CHECK ADD  CONSTRAINT [FK_Product_WireType] FOREIGN KEY([WireTypeId])
REFERENCES [dbo].[WireType] ([Id])
GO
ALTER TABLE [dbo].[Product] CHECK CONSTRAINT [FK_Product_WireType]
GO
ALTER TABLE [dbo].[User]  WITH CHECK ADD  CONSTRAINT [FK_User_Role] FOREIGN KEY([RoleId])
REFERENCES [dbo].[Role] ([Id])
GO
ALTER TABLE [dbo].[User] CHECK CONSTRAINT [FK_User_Role]
GO
USE [master]
GO
ALTER DATABASE [PRX301_Project] SET  READ_WRITE 
GO
