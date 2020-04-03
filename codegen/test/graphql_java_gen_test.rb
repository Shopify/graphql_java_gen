require 'test_helper'

class GraphQLJavaGenTest < Minitest::Test
  def test_that_it_has_a_version_number
    refute_nil ::GraphQLJavaGen::VERSION
  end

  def test_default_script_name
    output = GraphQLJavaGen.new(MINIMAL_SCHEMA, version: '2020-01', **required_args).generate
    assert_match %r{\A// Generated from graphql_java_gen gem$}, output
  end

  def test_script_name_option
    output = GraphQLJavaGen.new(MINIMAL_SCHEMA, script_name: 'script/update_schema', version: '2020-01', **required_args).generate
    assert_match %r{\A// Generated from script/update_schema$}, output
  end

  def test_generate
    refute_empty GraphQLJavaGen.new(LARGER_SCHEMA, version: '2020-01', **required_args).generate
  end

  private

  def required_args
    {
      package_name: "com.example.MyApp",
      nest_under: 'ExampleSchema',
    }
  end
end
