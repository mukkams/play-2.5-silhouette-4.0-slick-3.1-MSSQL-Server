
CREATE TABLE [dbo].[LoginInfo](
	[ID] [bigint] IDENTITY(1,1) NOT NULL,
	[ProviderID] [varchar](255) NOT NULL,
	[ProviderKey] [varchar](50) NOT NULL,
 CONSTRAINT [PK_LoginInfo] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

CREATE TABLE [dbo].[PasswordInfo](
	[Hasher] [varchar](255) NOT NULL,
	[Password] [varchar](255) NOT NULL,
	[Salt] [varchar](255) NULL,
	[LoginInfoId] [bigint] NOT NULL
) ON [PRIMARY]

GO

CREATE TABLE [dbo].[User](
	[userID] [varchar](100) NOT NULL,
	[firstName] [varchar](100) NULL,
	[lastName] [varchar](100) NULL,
	[fullName] [varchar](100) NULL,
	[email] [varchar](100) NULL,
	[avatarURL] [varchar](100) NULL,
PRIMARY KEY CLUSTERED
(
	[userID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

CREATE TABLE [dbo].[UserLoginInfo](
	[UserID] [uniqueidentifier] NOT NULL,
	[LoginInfoId] [bigint] NOT NULL
) ON [PRIMARY]

GO

