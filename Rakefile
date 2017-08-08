require "bundler/gem_tasks"

task test: :generate do |t|
  Dir.chdir('codegen') do
    system('rake', 'test') || abort
  end
  Dir.chdir('support') do
    system('./gradlew', 'check') || abort
  end
end

task :generate do
  require 'graphql_schema'
  require 'graphql_java_gen'
  require_relative 'codegen/test/support/schema'

  GraphQLJavaGen.new(
    GraphQLSchema.new(Support::Schema.introspection_result),
    package_name: 'com.shopify.graphql.support',
    nest_under: 'Generated',
    custom_scalars: [
      GraphQLJavaGen::Scalar.new(
        type_name: 'Time',
        java_type: 'LocalDateTime',
        deserialize_expr: ->(expr) { "LocalDateTime.parse(jsonAsString(#{expr}, key))" },
        imports: ['java.time.LocalDateTime'],
      )
    ],
    custom_annotations: [
      GraphQLJavaGen::Annotation.new(
        'Nullable',
        imports: ['com.shopify.graphql.support.Nullable']
      ) { |field| !field.type.non_null? },
    ]
  ).save('support/src/test/java/com/shopify/graphql/support/Generated.java')

  GraphQLJavaGen.new(
    GraphQLSchema.new(Support::Schema.introspection_result(Support::Schema::MinimalSchema)),
    package_name: 'com.shopify.graphql.support',
    nest_under: 'GeneratedMinimal',
  ).save('support/src/test/java/com/shopify/graphql/support/GeneratedMinimal.java')
end

task :default => :test
