PIDEV 4GL1-Bt
=============


# Gestion de Documents d'un bureau d'ordre #

## Fonctionnalités / Responsable



Ben Khlifa Ala

*   - [X] Gestion des Workflows

Nom de la Base `pidevdb` , Nom du DataSource (qui se trouve dans Persistance.xml) `PidevDS`

Persistance.xml contenu 

    <?xml version="1.0" encoding="UTF-8"?>
    <persistence version="2.1" xmlns="http://xmlns.jcp.org/xml/ns/persistence" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence http://xmlns.jcp.org/xml/ns/persistence/persistence_2_1.xsd" >
     <persistence-unit name="pidev-ejb">
      <jta-data-source>java:/PidevDS</jta-data-source>
      <properties>
       <property name="hibernate.hbm2ddl.auto" value="update"/>
      </properties>
     </persistence-unit>
    </persistence>