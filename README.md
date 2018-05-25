# GraphQLJavaGen
[![Build Status](https://travis-ci.org/Shopify/graphql_java_gen.svg?branch=master)](https://travis-ci.org/Shopify/graphql_java_gen)

Generate code for a specific GraphQL schema that provides query
builders and response classes.

## Installation

The code generator requires ruby version 2.1 or later.

It is recommended to use [bundler](http://bundler.io/) to install
the code generators ruby package.

Add this line to your application's Gemfile:

```ruby
gem 'graphql_java_gen'
```

And then execute:

    $ bundle

The generated code depends on the com.shopify.graphql.support java
package. This can be added to a gradle project by adding the following
jCenter dependancy to you `build.gradle` file:

    compile 'com.shopify.graphql.support:support:0.2.0'

## Usage

### Monolith (single file) schema generation

Create a script that generates the code for a GraphQL API

```ruby
require 'graphql_java_gen'
require 'graphql_schema'
require 'json'

introspection_result = File.read("graphql_schema.json")
schema = GraphQLSchema.new(JSON.parse(introspection_result))

GraphQLJavaGen.new(schema,
  package_name: "com.example.MyApp",
  nest_under: 'ExampleSchema',
  custom_scalars: [
    GraphQLJavaGen::Scalar.new(
      type_name: 'Decimal',
      java_type: 'BigDecimal',
      deserialize_expr: ->(expr) { "new BigDecimal(jsonAsString(#{expr}, key))" },
      imports: ['java.math.BigDecimal'],
    ),
  ]
).save("#{Dir.pwd}/../MyApp/src/main/java/com/example/MyApp/ExampleSchema.java")
```

The generated `ExampleSchema.java` will include a single class, `ExampleSchema`, which contains
all defined GraphQL schema entities as nested subclasses.


### Granular (multiple file) schema generation

You may also generate separate class files for each schema entity using the `save_granular` command.
In this case, you should provide the path to a directory, not a single class.

e.g.
```ruby
require 'graphql_java_gen'
require 'graphql_schema'
require 'json'

introspection_result = File.read("graphql_schema.json")
schema = GraphQLSchema.new(JSON.parse(introspection_result))

GraphQLJavaGen.new(schema,
  package_name: "com.example.MyApp",
  nest_under: 'ExampleSchema',
  custom_scalars: [
    GraphQLJavaGen::Scalar.new(
      type_name: 'Decimal',
      java_type: 'BigDecimal',
      deserialize_expr: ->(expr) { "new BigDecimal(jsonAsString(#{expr}, key))" },
      imports: ['java.math.BigDecimal'],
    ),
  ]
).save_granular("#{Dir.pwd}/../MyApp/src/main/java/com/example/MyApp/")
```

When using the granular option, the `com.example.MyApp` package wil contain many small
class files each containing a single GraphQL schema entity.

### Generated code

Regarless of whether you use the monolith or granular schema generator, the usage is largely the same.
The only difference depends on whether you access the schema entities directly from the provided package
or as nested, static classes on the `ExampleSchema` class.

That generated code depends on the com.shopify.graphql.support package.

The generated code includes a query builder that can be used to create a GraphQL
query in a type-safe manner.

```java
String queryString = ExampleSchema.query(query -> query
    .user(user -> user
        .firstName()
        .lastName()
    )
).toString();
```

The generated code also includes response classes that will deserialize the response
and provide methods for accessing the field data with it already coerced to the
correct type.

```java
ExampleSchema.QueryResponse response = ExampleSchema.QueryResponse.fromJson(responseJson);
if (!response.getErrors().isEmpty()) {
    for (Error error : response.getErrors()) {
        System.err.println("GraphQL error: " + error.message());
    }
}
if (data != null) {
    ExampleSchema.User user = data.getUser();
    System.out.println("user.firstName() + " " + user.lastName());
}
```

## Lambda Expressions

The java 8 lambda expressions feature is essential for having a
nice syntax for the query builder. This feature is also available
for Android apps by using the
[Jack toolchain](https://source.android.com/source/jack.html).

If an older version of java must be used, then
[retrolambda](https://github.com/orfjackal/retrolambda) can be used
to backport this feature to java 5-7.

## Development

After checking out the repo, run `bundle` to install ruby dependencies.
Then, run `rake test` to run the tests.

To install this gem onto your local machine, run `bundle exec rake
install` or reference it from a Gemfile using the path option
(e.g. `gem 'graphql_java_gen', path: '~/src/graphql_java_gen'`).

## Contributing

See our [contributing guidelines](CONTRIBUTING.md) for more information.

## License

The gem is available as open source under the terms of the
[MIT License](http://opensource.org/licenses/MIT).
