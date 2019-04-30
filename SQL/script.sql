USE [master]
GO
/****** Object:  Database [PRX301_Project]    Script Date: 4/30/2019 12:41:31 PM ******/
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
/****** Object:  Table [dbo].[GlassType]    Script Date: 4/30/2019 12:41:32 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GlassType](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](500) NULL,
	[Description] [nvarchar](max) NULL,
	[Active] [bit] NULL,
 CONSTRAINT [PK_GlassType] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Label]    Script Date: 4/30/2019 12:41:32 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Label](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](50) NULL,
	[Description] [nvarchar](max) NULL,
	[Status] [int] NULL,
	[Active] [bit] NULL,
 CONSTRAINT [PK_Label] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[MachineType]    Script Date: 4/30/2019 12:41:32 PM ******/
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
/****** Object:  Table [dbo].[Order]    Script Date: 4/30/2019 12:41:32 PM ******/
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
/****** Object:  Table [dbo].[OrderDetail]    Script Date: 4/30/2019 12:41:32 PM ******/
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
/****** Object:  Table [dbo].[Origin]    Script Date: 4/30/2019 12:41:32 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Origin](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](500) NULL,
	[Active] [bit] NULL,
 CONSTRAINT [PK_Origin] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Product]    Script Date: 4/30/2019 12:41:32 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Product](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](250) NULL,
	[Description] [nvarchar](max) NULL,
	[Price] [float] NULL,
	[WireTypeId] [int] NULL,
	[GlassTypeId] [int] NULL,
	[MachineTypeId] [int] NULL,
	[LabelId] [int] NULL,
	[OriginId] [int] NULL,
	[Status] [int] NULL,
	[ProductCode] [nvarchar](max) NULL,
	[CategoryId] [int] NULL,
	[Active] [bit] NULL,
 CONSTRAINT [PK_Product] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ProductCategory]    Script Date: 4/30/2019 12:41:32 PM ******/
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
/****** Object:  Table [dbo].[Role]    Script Date: 4/30/2019 12:41:32 PM ******/
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
/****** Object:  Table [dbo].[User]    Script Date: 4/30/2019 12:41:32 PM ******/
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
/****** Object:  Table [dbo].[WireType]    Script Date: 4/30/2019 12:41:32 PM ******/
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

INSERT [dbo].[GlassType] ([Id], [Name], [Description], [Active]) VALUES (1, N'Bơi Lặn', N'Chống thấm nước', 1)
INSERT [dbo].[GlassType] ([Id], [Name], [Description], [Active]) VALUES (2, N'Chronograph', NULL, 1)
INSERT [dbo].[GlassType] ([Id], [Name], [Description], [Active]) VALUES (3, N'Classic', N'Phong cách cổ điển', 1)
INSERT [dbo].[GlassType] ([Id], [Name], [Description], [Active]) VALUES (4, N'Luxury', N'Phong cách quý tộc', 1)
INSERT [dbo].[GlassType] ([Id], [Name], [Description], [Active]) VALUES (5, N'Skeleton', N'Lộ máy', 1)
INSERT [dbo].[GlassType] ([Id], [Name], [Description], [Active]) VALUES (6, N'Smart Watch', N'Công nghệ hiện đại', 1)
SET IDENTITY_INSERT [dbo].[GlassType] OFF
SET IDENTITY_INSERT [dbo].[Label] ON 

INSERT [dbo].[Label] ([Id], [Name], [Description], [Status], [Active]) VALUES (1, N'Seiko', N'thương hiệu nhật bản', 1, 1)
INSERT [dbo].[Label] ([Id], [Name], [Description], [Status], [Active]) VALUES (2, N'Citizen', N'thương hiệu nhật bản', 1, 1)
INSERT [dbo].[Label] ([Id], [Name], [Description], [Status], [Active]) VALUES (3, N'Tissot', N'thương hiệu Thụy Sỹ', 1, 1)
INSERT [dbo].[Label] ([Id], [Name], [Description], [Status], [Active]) VALUES (4, N'Rolex', N'thương hiệu Thụy Sỹ', 1, 1)
INSERT [dbo].[Label] ([Id], [Name], [Description], [Status], [Active]) VALUES (5, N'Phillip Pattek', N'thương hiệu đại gia', 1, 1)
INSERT [dbo].[Label] ([Id], [Name], [Description], [Status], [Active]) VALUES (6, N'Oris', N'thương hiệu Thụy Sỹ', 1, 1)
INSERT [dbo].[Label] ([Id], [Name], [Description], [Status], [Active]) VALUES (7, N'Casio', N'Thương hiệu nhật bản', 1, 1)
SET IDENTITY_INSERT [dbo].[Label] OFF
SET IDENTITY_INSERT [dbo].[MachineType] ON 

INSERT [dbo].[MachineType] ([Id], [Name], [Description], [Active]) VALUES (1, N'đồng hồ cơ', N'Chạy bằng cơ học', 1)
INSERT [dbo].[MachineType] ([Id], [Name], [Description], [Active]) VALUES (2, N'đồng hồ điện tử ', N'chạy bằng điện tử', 1)
INSERT [dbo].[MachineType] ([Id], [Name], [Description], [Active]) VALUES (3, N'Solar', N'chạy bằng năng lượng mặt trời', 1)
SET IDENTITY_INSERT [dbo].[MachineType] OFF
SET IDENTITY_INSERT [dbo].[Origin] ON 

INSERT [dbo].[Origin] ([Id], [Name], [Active]) VALUES (1, N'Thụy Sĩ', 1)
INSERT [dbo].[Origin] ([Id], [Name], [Active]) VALUES (2, N'Nhật bản', 1)
SET IDENTITY_INSERT [dbo].[Origin] OFF
SET IDENTITY_INSERT [dbo].[Product] ON 

INSERT [dbo].[Product] ([Id], [Name], [Description], [Price], [WireTypeId], [GlassTypeId], [MachineTypeId], [LabelId], [OriginId], [Status], [ProductCode], [CategoryId], [Active]) VALUES (1, N'ĐỒNG HỒ SEIKO SRZ397P1', N'ĐỒNG HỒ SEIKO SRZ397P1', 7360000, 2, 1, 1, 1, 2, 1, N'AAA', 1, 1)
INSERT [dbo].[Product] ([Id], [Name], [Description], [Price], [WireTypeId], [GlassTypeId], [MachineTypeId], [LabelId], [OriginId], [Status], [ProductCode], [CategoryId], [Active]) VALUES (2, N'ĐỒNG HỒ SEIKO SSC355P1', N'ĐỒNG HỒ SEIKO SSC355P1', 13915000, 2, 1, 1, 1, 2, 1, N'BBBB', 1, 0)
INSERT [dbo].[Product] ([Id], [Name], [Description], [Price], [WireTypeId], [GlassTypeId], [MachineTypeId], [LabelId], [OriginId], [Status], [ProductCode], [CategoryId], [Active]) VALUES (3, N'ĐỒNG HỒ PATEK PHILIPPE 5372P', N'ĐỒNG HỒ PATEK PHILIPPE 5372P', 11212410000, 2, 1, 1, 4, 1, 1, N'5372P', 1, 1)
INSERT [dbo].[Product] ([Id], [Name], [Description], [Price], [WireTypeId], [GlassTypeId], [MachineTypeId], [LabelId], [OriginId], [Status], [ProductCode], [CategoryId], [Active]) VALUES (4, N'ĐỒNG HỒ PATEK PHILIPPE 5320G', N'ĐỒNG HỒ PATEK PHILIPPE 5320G', 1812360000, 2, 1, 1, 4, 1, 1, N'5320G', 1, 1)
INSERT [dbo].[Product] ([Id], [Name], [Description], [Price], [WireTypeId], [GlassTypeId], [MachineTypeId], [LabelId], [OriginId], [Status], [ProductCode], [CategoryId], [Active]) VALUES (5, N'ĐỒNG HỒ PATEK PHILIPPE 5316P', N'ĐỒNG HỒ PATEK PHILIPPE 5316P', 17793000000, 2, 1, 1, 4, 1, 1, N'5316P', 1, 1)
INSERT [dbo].[Product] ([Id], [Name], [Description], [Price], [WireTypeId], [GlassTypeId], [MachineTypeId], [LabelId], [OriginId], [Status], [ProductCode], [CategoryId], [Active]) VALUES (7, N'ĐỒNG HỒ TISSOT T085.410.11.011.00', N'ĐỒNG HỒ TISSOT T085.410.11.011.00', 9070000, 4, 1, 1, 3, 1, 1, N'T085.410.11.011.00', 1, 1)
INSERT [dbo].[Product] ([Id], [Name], [Description], [Price], [WireTypeId], [GlassTypeId], [MachineTypeId], [LabelId], [OriginId], [Status], [ProductCode], [CategoryId], [Active]) VALUES (8, N'ĐỒNG HỒ TISSOT T084.210.11.116.01', N'ĐỒNG HỒ TISSOT', 10980000, 4, 1, 1, 3, 1, 1, N'T084.210.11.116.01', 1, 1)
INSERT [dbo].[Product] ([Id], [Name], [Description], [Price], [WireTypeId], [GlassTypeId], [MachineTypeId], [LabelId], [OriginId], [Status], [ProductCode], [CategoryId], [Active]) VALUES (9, N'ĐỒNG HỒ CITIZEN BI5006-81P', N'ĐỒNG HỒ CITIZEN BI5006-81P', 2900000, 4, 1, 1, 2, 2, 1, N'BI5006-81P', 1, 1)
INSERT [dbo].[Product] ([Id], [Name], [Description], [Price], [WireTypeId], [GlassTypeId], [MachineTypeId], [LabelId], [OriginId], [Status], [ProductCode], [CategoryId], [Active]) VALUES (10, N'Đồng Hồ Citizen BI1052-85P', N'Đồng Hồ Citizen BI1052-85P', 3400000, 4, 1, 1, 2, 2, 1, N'BI1052-85P', 1, 1)
INSERT [dbo].[Product] ([Id], [Name], [Description], [Price], [WireTypeId], [GlassTypeId], [MachineTypeId], [LabelId], [OriginId], [Status], [ProductCode], [CategoryId], [Active]) VALUES (11, N'ĐỒNG HỒ CITIZEN BJ6501-28A', N'ĐĐỒNG HỒ CITIZEN BJ6501-28A', 4700000, 2, 1, 1, 2, 2, 1, N'BI1052-85P', 1, 1)
INSERT [dbo].[Product] ([Id], [Name], [Description], [Price], [WireTypeId], [GlassTypeId], [MachineTypeId], [LabelId], [OriginId], [Status], [ProductCode], [CategoryId], [Active]) VALUES (12, N'ĐỒNG HỒ CITIZEN BJ6501-10L', N'ĐỒNG HỒ CITIZEN BJ6501-10L', 4700000, 2, 1, 1, 2, 2, 1, N'BJ6501-10L', 1, 1)
INSERT [dbo].[Product] ([Id], [Name], [Description], [Price], [WireTypeId], [GlassTypeId], [MachineTypeId], [LabelId], [OriginId], [Status], [ProductCode], [CategoryId], [Active]) VALUES (13, N'ĐỒNG HỒ CITIZEN BJ6501-01E', N'ĐỒNG HỒ CITIZEN BJ6501-01E', 4700000, 2, 1, 1, 2, 2, 1, N'BJ6501-01E', 1, 1)
INSERT [dbo].[Product] ([Id], [Name], [Description], [Price], [WireTypeId], [GlassTypeId], [MachineTypeId], [LabelId], [OriginId], [Status], [ProductCode], [CategoryId], [Active]) VALUES (14, N'ĐỒNG HỒ SEIKO SXDG58P1', N'ĐỒNG HỒ SEIKO SXDG58P1', 14950000, 2, 1, 1, 1, 2, 1, N'SXDG58P1', 1, 1)
INSERT [dbo].[Product] ([Id], [Name], [Description], [Price], [WireTypeId], [GlassTypeId], [MachineTypeId], [LabelId], [OriginId], [Status], [ProductCode], [CategoryId], [Active]) VALUES (15, N'ĐỒNG HỒ SEIKO SUR138P1', N'ĐỒNG HỒ SEIKO SUR138P1', 5980000, 2, 1, 1, 1, 2, 1, N'SUR138P1', 1, 1)
SET IDENTITY_INSERT [dbo].[Product] OFF
SET IDENTITY_INSERT [dbo].[ProductCategory] ON 

INSERT [dbo].[ProductCategory] ([Id], [Name], [Description], [Status], [Active]) VALUES (1, N'Đồng Hồ', N'Đây là đồng hồ', 1, 1)
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
