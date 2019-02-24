# RmUtils
Projeto com métodos utilitários em java:
- Formatar Datas;
- Formatar Números Decimais;
- Escrever arquivo CSV;
- Validar CPF e CNPJ;

To get a Git project into your build:

# Step 1. Add the JitPack repository to your project

Add it in your root build.gradle or pom.xml at the end of repositories:

# Gradle
```
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}
```
# Maven
```
<repositories>
	<repository>
	    <id>jitpack.io</id>
	    <url>https://jitpack.io</url>
	</repository>
</repositories>

```
  
  
# Step 2. Add the dependency

# Gradle
```
dependencies {
	        implementation 'com.github.RomarioTeles:RmUtils:-SNAPSHOT'
}

```

# Maven
```
<dependency>
    <groupId>com.github.RomarioTeles</groupId>
    <artifactId>RmUtils</artifactId>
    <version>Tag</version>
</dependency>

```


