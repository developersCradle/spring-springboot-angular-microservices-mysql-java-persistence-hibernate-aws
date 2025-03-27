The course now provides source-code only as Maven projects. 
It earlier used to provide source-code as plain Java projects as well (along with required JAR files) but since the release of Hibernate 6 it doesn't do that anymore.

This is to avoid providing 2 different copies for the same source-code as the source-code that worked with Hibernate 4 & 5 didn't work with Hibernate 6. 
It's due to the fact that since the Hibernate 6 release the javax.* package got changed to the jakarta.* package.

So you don't need any separate JAR files anymore as only Maven source-code is provided now.