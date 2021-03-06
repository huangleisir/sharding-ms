package com.steven.config.sharding;

/**
 * @author donghongchen
 * @create 2017-12-05 10:02
 **/
//@Configuration
//@EnableConfigurationProperties({SpringBootShardingRuleConfigurationProperties.class, SpringBootMasterSlaveRuleConfigurationProperties.class})
//public class DataSourceConfig implements EnvironmentAware {
//
//    @Autowired
//    private SpringBootShardingRuleConfigurationProperties shardingProperties;
//
//    @Autowired
//    private SpringBootMasterSlaveRuleConfigurationProperties masterSlaveProperties;
//
//    private final Map<String, DataSource> dataSourceMap = new HashMap<>();
//
//    private final Properties props = new Properties();
//
//    @Bean
//    public DataSource dataSource() throws SQLException {
//        DataSource dataSource;
//        if (null == masterSlaveProperties.getMasterDataSourceName()) {
//            ShardingRuleConfiguration shardingRuleConfiguration=shardingProperties.getShardingRuleConfiguration();
//            Map map=shardingProperties.getConfigMap();
//            dataSource = ShardingDataSourceFactory.createDataSource(dataSourceMap, shardingRuleConfiguration, map, props);
//        } else {
//            MasterSlaveRuleConfiguration masterSlaveRuleConfiguration = masterSlaveProperties.getMasterSlaveRuleConfiguration();
//            Map map = masterSlaveProperties.getConfigMap();
//            dataSource = MasterSlaveDataSourceFactory.createDataSource(dataSourceMap, masterSlaveRuleConfiguration, map);
//        }
//        return dataSource;
////        return null == masterSlaveProperties.getMasterDataSourceName()
////                ? ShardingDataSourceFactory.createDataSource(dataSourceMap, shardingProperties.getShardingRuleConfiguration(), shardingProperties.getConfigMap(), props)
////                : MasterSlaveDataSourceFactory.createDataSource(dataSourceMap, masterSlaveProperties.getMasterSlaveRuleConfiguration(), masterSlaveProperties.getConfigMap());
//    }
//
//    @Override
//    public void setEnvironment(final Environment environment) {
//        setDataSourceMap(environment);
//        setShardingProperties(environment);
//    }
//
//    private void setDataSourceMap(final Environment environment) {
//        RelaxedPropertyResolver propertyResolver = new RelaxedPropertyResolver(environment, "sharding.jdbc.datasource.");
//        String dataSources = propertyResolver.getProperty("names");
//        for (String each : dataSources.split(",")) {
//            try {
//                Map<String, Object> dataSourceProps = propertyResolver.getSubProperties(each + ".");
//                Preconditions.checkState(!dataSourceProps.isEmpty(), "Wrong datasource properties!");
//                DataSource dataSource = DataSourceUtil.getDataSource(dataSourceProps.get("type").toString(), dataSourceProps);
//                dataSourceMap.put(each, dataSource);
//            } catch (final ReflectiveOperationException ex) {
//                throw new ShardingJdbcException("Can't find datasource type!", ex);
//            }
//        }
//    }
//
//    private void setShardingProperties(final Environment environment) {
//        RelaxedPropertyResolver propertyResolver = new RelaxedPropertyResolver(environment, "sharding.jdbc.config.sharding.props.");
//        String showSQL = propertyResolver.getProperty(ShardingPropertiesConstant.SQL_SHOW.getKey());
//        if (!Strings.isNullOrEmpty(showSQL)) {
//            props.setProperty(ShardingPropertiesConstant.SQL_SHOW.getKey(), showSQL);
//        }
//        String executorSize = propertyResolver.getProperty(ShardingPropertiesConstant.EXECUTOR_SIZE.getKey());
//        if (!Strings.isNullOrEmpty(executorSize)) {
//            props.setProperty(ShardingPropertiesConstant.EXECUTOR_SIZE.getKey(), executorSize);
//        }
//    }
//}