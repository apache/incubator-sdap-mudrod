/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you 
 * may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.sdap.mudrod.main;

import org.apache.sdap.mudrod.driver.EmbeddedElasticsearchServer;
import org.apache.sdap.mudrod.driver.EmbeddedElasticsearchServer;
import org.elasticsearch.client.Client;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 * This is a helper class the starts an embedded elasticsearch server for each
 * test.
 */
public abstract class AbstractElasticsearchIntegrationTest {

  private static EmbeddedElasticsearchServer embeddedElasticsearchServer;

  @BeforeClass
  public static void startEmbeddedElasticsearchServer() {
    if(embeddedElasticsearchServer == null){
      embeddedElasticsearchServer = new EmbeddedElasticsearchServer();
    }
  }

  @AfterClass
  public static void shutdownEmbeddedElasticsearchServer() {
    embeddedElasticsearchServer.shutdown();
  }

  /**
   * By using this method you can access the embedded server.
   */
  protected Client getClient() {
    return embeddedElasticsearchServer.getClient();
  }
}