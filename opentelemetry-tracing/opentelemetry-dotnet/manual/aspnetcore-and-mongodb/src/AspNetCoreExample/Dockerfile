FROM mcr.microsoft.com/dotnet/sdk:8.0 as build

WORKDIR /build
COPY . .
RUN dotnet tool install -g Cake.Tool
ENV PATH="${PATH}:/root/.dotnet/tools"
RUN dotnet cake build.cake --runtime=linux-x64

FROM mcr.microsoft.com/dotnet/aspnet:8.0

COPY --from=build /build/publish /app
WORKDIR /app

EXPOSE 5000

ENTRYPOINT ["dotnet", "AspNetCoreExample.dll"]
