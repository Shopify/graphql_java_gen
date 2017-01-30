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

  schema = GraphQLSchema.new(Support::Schema.introspection_result)
  generator = GraphQLJavaGen.new(schema,
    package_name: 'com.shopify.graphql.support',
    nest_under: 'Generated',
    custom_scalars: [
      GraphQLJavaGen::Scalar.new(
        type_name: 'Time',
        java_type: 'LocalDateTime',
        deserialize_expr: ->(expr) { "LocalDateTime.parse(jsonAsString(#{expr}, key))" },
        imports: ['java.time.LocalDateTime'],
      )
    ]
  )
  generator.save('support/src/test/java/com/shopify/graphql/support/Generated.java')
end

task :default => :test
