# Spring OAuth2 Server

### Usage

The schema to create database are in the folder `src/dbscripts`.
Create the schema and use the client `ezdi` to test whether you are able
to get the oauth access token using following command:

`curl --user ezdi:ezdisecret --request POST "$token_url?grant_type=password&username=adminuser&password=adminuser"`

Once you get the access token the you can use it to query the resource
server from the `oauth-resource-server` project.

### Configuration

To enable authorization server we need to first add annotation
`@EnableAuthorizationServer` and then extend the class with
`AuthorizationServerConfigurerAdapter`. Before you do any authorization
we need to add authentication server. Here in this example we have
implemented a JDBC based user authentication using JPA repository.
Also we need to store the client information that we are doing into
the JDBC to.

For token store we are using JWT token store. JWT token store are
required to carry extra information that can then be used at resource
server side.
