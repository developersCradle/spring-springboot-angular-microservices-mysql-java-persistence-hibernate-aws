# Section 02: Jackson Fundamentals.

Jackson Fundamentals.

# What I Learned.

# Serialize a Java object into a JSON string.

<div align="center">
	<img src="Serialize_Java_Object_Into_JSON_String_Intro.PNG"  alt="Jackson Quick Start : JSON Serialization With Java Made Easy!" width="600"/>
</div>

1. We will be seeing how the **Java Object** is serialized into **JSON string**!

<div align="center">
	<img src="WriteValueAsString.PNG"  alt="Jackson Quick Start : JSON Serialization With Java Made Easy!" width="600"/>
</div>

1. We call the `.writeValueAsString(...)` to serialize **Java Object** to **JSON**!

# Serialize a Java object into a JSON file.

<div align="center">
	<img src="Serialize_Java_Object_Into_JSON_File_Intro.PNG"  alt="Jackson Quick Start : JSON Serialization With Java Made Easy!" width="600"/>
</div>

1. We will serialize **JSON file** using **Jacksons object** mapper!

<div align="center">
	<img src="writeValue_To_File.PNG"  alt="Jackson Quick Start : JSON Serialization With Java Made Easy!" width="600"/>
</div>

1. We will use the `.writeValue(...)` to write to specific file!

<div align="center">
	<img src="Serialize_Fields_Of_An_Object.PNG"  alt="Jackson Quick Start : JSON Serialization With Java Made Easy!" width="600"/>
</div>

1. We have the following fields in the `outline.json`!

# De-serialize a JSON string into a Java object.

<div align="center">
	<img src="De_Serialize_JSON_String_Into_Java_Object_Intro.PNG"  alt="Jackson Quick Start : JSON Serialization With Java Made Easy!" width="600"/>
</div>

1. We will, we **deserialize** the **JSON** into **Java Object!**

<div align="center">
	<img src="De_Serialize_JSON_String_Into_Java_Object.PNG"  alt="Jackson Quick Start : JSON Serialization With Java Made Easy!" width="600"/>
</div>

1. We are using the `.readValue(...)` to deserialize the **JSON String** to the **Java Object**!

# De-serialize a JSON file into a Java object.

<div align="center">
	<img src="Serialize_Java_Object_Into_JSON_File_Intro.PNG"  alt="Jackson Quick Start : JSON Serialization With Java Made Easy!" width="600"/>
</div>

1. We will be **deserialization JSON file** to **Java Object**!

<div align="center">
	<img src="JSON_As_File.PNG"  alt="Jackson Quick Start : JSON Serialization With Java Made Easy!" width="600"/>
</div>

1. We are having following as **JSON** as file!

<div align="center">
	<img src="De_Serialize_JSON_File_Into_Java_Object.PNG"  alt="Jackson Quick Start : JSON Serialization With Java Made Easy!" width="600"/>
</div>

1. We will be loading the **JSON file**!
2. Reading to the **Java Object**!


# Serialize a Java List to a JSON string.

<div align="center">
	<img src="Serialize_Java_List_To_JSON_String_Intro.PNG"  alt="Jackson Quick Start : JSON Serialization With Java Made Easy!" width="600"/>
</div>

1. We will **serialize** the Java List into JSON string!

<div align="center">
	<img src="Converting_List_To_JSON.PNG"  alt="Jackson Quick Start : JSON Serialization With Java Made Easy!" width="600"/>
</div>

1. Are using collection to Java List, with the `.writeValueAsString(...)`.

<div align="center">
	<img src="List_As_Java.PNG"  alt="Jackson Quick Start : JSON Serialization With Java Made Easy!" width="600"/>
</div>

1. When list get serialized, it looks as following!
	- There is no key-values!

# Serialize a Java Map to a JSON string.

<div align="center">
	<img src="Serialize_Java_Map_To_JSON_String_Intro.PNG"  alt="Jackson Quick Start : JSON Serialization With Java Made Easy!" width="600"/>
</div>

1. Java Map into JSON String!

<div align="center">
	<img src="Map_As_Java.PNG"  alt="Jackson Quick Start : JSON Serialization With Java Made Easy!" width="600"/>
</div>

1. Are using collection to Java Map, with the `.writeValueAsString(...)`.

<div align="center">
	<img src="Java_Map_Serialization.PNG"  alt="Jackson Quick Start : JSON Serialization With Java Made Easy!" width="600"/>
</div>

1. Key value pair serialized!

# @JsonAlias annotation during serialization.

<div align="center">
	<img src="At_JsonAlias_Annotation_During_Serialization_Intro.PNG"  alt="Jackson Quick Start : JSON Serialization With Java Made Easy!" width="600"/>
</div>

1. `@JsonAlias` helps in naming deserialization during the serialization!

<div align="center">
	<img src="Alias_Annotation.PNG"  alt="Jackson Quick Start : JSON Serialization With Java Made Easy!" width="600"/>
</div>

1. We can use for different fields names.
2. We can use for different fields names.

- We can see the mapping working:

<div align="center">
	<img src="Mapping_Working.PNG"  alt="Jackson Quick Start : JSON Serialization With Java Made Easy!" width="600"/>
</div>

- Next, if we have mismatching fields:

<div align="center">
	<img src="Error_In_Missmatch.PNG"  alt="Jackson Quick Start : JSON Serialization With Java Made Easy!" width="600"/>
</div>

# @JsonIgnore annotation during serialization.

<div align="center">
	<img src="At_JsonIgnore_Annotation_During_Serialization.PNG"  alt="Jackson Quick Start : JSON Serialization With Java Made Easy!" width="600"/>
</div>

1. `@JsonIgnore` allows ignore fields in serialization process!

<div align="center">
	<img src="JsonIgnore.PNG"  alt="Jackson Quick Start : JSON Serialization With Java Made Easy!" width="600"/>
</div>

1. We can ignore fields from JSON string with the `@JsonIgnore`!

# @JsonIgnore annotation during deserialization.

<div align="center">
	<img src="At_JsonIgnore_Annotation_During_Deserialization.PNG"  alt="Jackson Quick Start : JSON Serialization With Java Made Easy!" width="600"/>
</div>

1. `@JsonIgnore` allows ignore fields in deserialization process!

<div align="center">
	<img src="JsonIgnore_In_De_Serialization.PNG"  alt="Jackson Quick Start : JSON Serialization With Java Made Easy!" width="600"/>
</div>

1. We can say, the field stays the same!

# Serialization of Java objects containing other Java objects.

<div align="center">
	<img src="Serialization_Of_Java_Objects_Containing_Other_Java_Objects_Intro.PNG"  alt="Jackson Quick Start : JSON Serialization With Java Made Easy!" width="600"/>
</div>

1. Serialize Objects inside Object!

<div align="center">
	<img src="Pretty_Printing.PNG"  alt="Jackson Quick Start : JSON Serialization With Java Made Easy!" width="600"/>
</div>

1. Pretty Printing for clear JSON!

<div align="center">
	<img src="Java_Object_Inside_Object.PNG"  alt="Jackson Quick Start : JSON Serialization With Java Made Easy!" width="600"/>
</div>

1. Java Object inside Java Object!

<div align="center">
	<img src="Object_Inside_Object.PNG"  alt="Jackson Quick Start : JSON Serialization With Java Made Easy!" width="600"/>
</div>

1. Object serialization!
2. Object inside Object serialization!

# Deserialization of Java objects containing other objects.

<div align="center">
	<img src="Deserialization_Of_Java_Objects_Containing_Other_Objects_Intro.PNG"  alt="Jackson Quick Start : JSON Serialization With Java Made Easy!" width="600"/>
</div>

1. Same, but in deserialization way!

<div align="center">
	<img src="We_Have_Object_Inside_Object_In_JSON.PNG"  alt="Jackson Quick Start : JSON Serialization With Java Made Easy!" width="600"/>
</div>

1. We are looking **JSON**, where is **Object** inside **Object**!

<div align="center">
	<img src="Object_Inside_Object_In_De_Serialization.PNG"  alt="Jackson Quick Start : JSON Serialization With Java Made Easy!" width="600"/>
</div>

1. We are looking at **Computer** class!

<div align="center">
	<img src="JSON_De_Serialization.PNG"  alt="Jackson Quick Start : JSON Serialization With Java Made Easy!" width="600"/>
</div>

1. We can see the fields being deserialized!