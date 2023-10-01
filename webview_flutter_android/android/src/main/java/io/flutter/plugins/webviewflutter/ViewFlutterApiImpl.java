// Copyright 2013 The Flutter Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package io.flutter.plugins.webviewflutter;


import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;

import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView.ViewFlutterApi;

public class ViewFlutterApiImpl {
  private final BinaryMessenger binaryMessenger;

  private final InstanceManager instanceManager;
  private ViewFlutterApi api;

  public ViewFlutterApiImpl(
      @NonNull BinaryMessenger binaryMessenger, @NonNull InstanceManager instanceManager) {
    this.binaryMessenger = binaryMessenger;
    this.instanceManager = instanceManager;
    api = new ViewFlutterApi(binaryMessenger);
  }

  public void create(
      @NonNull View instance,
      @NonNull ViewFlutterApi.Reply<Void> callback) {
    if (!instanceManager.containsInstance(instance)) {
      api.create(
          instanceManager.addHostCreatedInstance(instance), callback);
    }
  }

  @VisibleForTesting
  void setApi(@NonNull ViewFlutterApi api) {
    this.api = api;
  }
}
