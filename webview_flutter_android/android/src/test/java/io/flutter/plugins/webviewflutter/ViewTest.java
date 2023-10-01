// Copyright 2013 The Flutter Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package io.flutter.plugins.webviewflutter;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

import android.view.View;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.Objects;

import io.flutter.plugin.common.BinaryMessenger;

public class ViewTest {
  @Rule public MockitoRule mockitoRule = MockitoJUnit.rule();

  @Mock public View mockView;

  @Mock public BinaryMessenger mockBinaryMessenger;

  @Mock
  public GeneratedAndroidWebView.ViewFlutterApi
      mockFlutterApi;

  InstanceManager instanceManager;

  @Before
  public void setUp() {
    instanceManager = InstanceManager.create(identifier -> {});
  }

  @After
  public void tearDown() {
    instanceManager.stopFinalizationListener();
  }

  @Test
  public void flutterApiCreate() {
    final ViewFlutterApiImpl flutterApi =
        new ViewFlutterApiImpl(mockBinaryMessenger, instanceManager);
    flutterApi.setApi(mockFlutterApi);
    flutterApi.create(mockView, reply -> {});

    final long instanceIdentifier =
        Objects.requireNonNull(
            instanceManager.getIdentifierForStrongReference(mockView));
    verify(mockFlutterApi).create(eq(instanceIdentifier), any());
  }
}
