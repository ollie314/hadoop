/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.hadoop.yarn.server.api.impl.pb.service;

import com.google.protobuf.RpcController;
import com.google.protobuf.ServiceException;
import org.apache.hadoop.yarn.server.api.DistributedSchedulerProtocol;
import org.apache.hadoop.yarn.proto.YarnServerCommonServiceProtos;
import org.apache.hadoop.yarn.server.api.DistributedSchedulerProtocolPB;
import org.apache.hadoop.yarn.api.protocolrecords.AllocateResponse;
import org.apache.hadoop.yarn.server.api.protocolrecords.DistSchedAllocateResponse;
import org.apache.hadoop.yarn.server.api.protocolrecords.DistSchedRegisterResponse;
import org.apache.hadoop.yarn.api.protocolrecords
    .FinishApplicationMasterResponse;
import org.apache.hadoop.yarn.api.protocolrecords.RegisterApplicationMasterResponse;
import org.apache.hadoop.yarn.api.protocolrecords.impl.pb.AllocateRequestPBImpl;
import org.apache.hadoop.yarn.api.protocolrecords.impl.pb.AllocateResponsePBImpl;
import org.apache.hadoop.yarn.server.api.protocolrecords.impl.pb.DistSchedAllocateRequestPBImpl;
import org.apache.hadoop.yarn.server.api.protocolrecords.impl.pb.DistSchedAllocateResponsePBImpl;
import org.apache.hadoop.yarn.server.api.protocolrecords.impl.pb.DistSchedRegisterResponsePBImpl;
import org.apache.hadoop.yarn.api.protocolrecords.impl.pb
    .FinishApplicationMasterRequestPBImpl;
import org.apache.hadoop.yarn.api.protocolrecords.impl.pb
    .FinishApplicationMasterResponsePBImpl;
import org.apache.hadoop.yarn.api.protocolrecords.impl.pb.RegisterApplicationMasterRequestPBImpl;
import org.apache.hadoop.yarn.api.protocolrecords.impl.pb.RegisterApplicationMasterResponsePBImpl;
import org.apache.hadoop.yarn.exceptions.YarnException;
import org.apache.hadoop.yarn.proto.YarnServiceProtos;
import org.apache.hadoop.yarn.proto.YarnServiceProtos.AllocateRequestProto;
import org.apache.hadoop.yarn.proto.YarnServiceProtos.RegisterApplicationMasterRequestProto;

import java.io.IOException;

public class DistributedSchedulerProtocolPBServiceImpl implements
    DistributedSchedulerProtocolPB {

  private DistributedSchedulerProtocol real;

  public DistributedSchedulerProtocolPBServiceImpl(
      DistributedSchedulerProtocol impl) {
    this.real = impl;
  }

  @Override
  public YarnServerCommonServiceProtos.DistSchedRegisterResponseProto
  registerApplicationMasterForDistributedScheduling(RpcController controller,
      RegisterApplicationMasterRequestProto proto) throws
      ServiceException {
    RegisterApplicationMasterRequestPBImpl request = new
        RegisterApplicationMasterRequestPBImpl(proto);
    try {
      DistSchedRegisterResponse response =
          real.registerApplicationMasterForDistributedScheduling(request);
      return ((DistSchedRegisterResponsePBImpl) response).getProto();
    } catch (YarnException e) {
      throw new ServiceException(e);
    } catch (IOException e) {
      throw new ServiceException(e);
    }
  }

  @Override
  public YarnServerCommonServiceProtos.DistSchedAllocateResponseProto
  allocateForDistributedScheduling(RpcController controller,
      YarnServerCommonServiceProtos.DistSchedAllocateRequestProto proto)
      throws ServiceException {
    DistSchedAllocateRequestPBImpl request =
        new DistSchedAllocateRequestPBImpl(proto);
    try {
      DistSchedAllocateResponse response = real
          .allocateForDistributedScheduling(request);
      return ((DistSchedAllocateResponsePBImpl) response).getProto();
    } catch (YarnException e) {
      throw new ServiceException(e);
    } catch (IOException e) {
      throw new ServiceException(e);
    }
  }

  @Override
  public YarnServiceProtos.AllocateResponseProto allocate(RpcController arg0,
      AllocateRequestProto proto) throws ServiceException {
    AllocateRequestPBImpl request = new AllocateRequestPBImpl(proto);
    try {
      AllocateResponse response = real.allocate(request);
      return ((AllocateResponsePBImpl) response).getProto();
    } catch (YarnException e) {
      throw new ServiceException(e);
    } catch (IOException e) {
      throw new ServiceException(e);
    }
  }

  @Override
  public YarnServiceProtos.FinishApplicationMasterResponseProto
  finishApplicationMaster(
      RpcController arg0, YarnServiceProtos
      .FinishApplicationMasterRequestProto proto)
      throws ServiceException {
    FinishApplicationMasterRequestPBImpl request = new
        FinishApplicationMasterRequestPBImpl(proto);
    try {
      FinishApplicationMasterResponse response = real.finishApplicationMaster
          (request);
      return ((FinishApplicationMasterResponsePBImpl) response).getProto();
    } catch (YarnException e) {
      throw new ServiceException(e);
    } catch (IOException e) {
      throw new ServiceException(e);
    }
  }

  @Override
  public YarnServiceProtos.RegisterApplicationMasterResponseProto
  registerApplicationMaster(
      RpcController arg0, RegisterApplicationMasterRequestProto proto)
      throws ServiceException {
    RegisterApplicationMasterRequestPBImpl request = new
        RegisterApplicationMasterRequestPBImpl(proto);
    try {
      RegisterApplicationMasterResponse response = real
          .registerApplicationMaster(request);
      return ((RegisterApplicationMasterResponsePBImpl) response).getProto();
    } catch (YarnException e) {
      throw new ServiceException(e);
    } catch (IOException e) {
      throw new ServiceException(e);
    }
  }
}
