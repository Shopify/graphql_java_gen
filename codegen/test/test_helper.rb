$LOAD_PATH.unshift File.expand_path('../../lib', __FILE__)
require 'graphql_java_gen'
require 'graphql_schema'
require 'json'

require 'minitest/autorun'

require 'support/schema'

MINIMAL_SCHEMA = GraphQLSchema.new(Support::Schema.introspection_result(Support::Schema::MinimalSchema))
LARGER_SCHEMA = GraphQLSchema.new(Support::Schema.introspection_result)
