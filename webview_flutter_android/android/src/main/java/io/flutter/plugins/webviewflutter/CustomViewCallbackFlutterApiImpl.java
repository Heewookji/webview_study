// Copyright 2013 The Flutter Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package io.flutter.plugins.webviewflutter;

import android.webkit.WebChromeClient.CustomViewCallback;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;

import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView.CustomViewCallbackFlutterApi;

public class CustomViewCallbackFlutterApiImpl {
  private final BinaryMessenger binaryMessenger;

  private final InstanceManager instanceManager;
  private CustomViewCallbackFlutterApi api;

  public CustomViewCallbackFlutterApiImpl(
      @NonNull BinaryMessenger binaryMessenger, @NonNull InstanceManager instanceManager) {
    this.binaryMessenger = binaryMessenger;
    this.instanceManager = instanceManager;
    api = new CustomViewCallbackFlutterApi(binaryMessenger);
  }

  public void create(
      @NonNull CustomViewCallback instance,
      @NonNull CustomViewCallbackFlutterApi.Reply<Void> callback) {
    if (!instanceManager.containsInstance(instance)) {
      api.create(
          instanceManager.addHostCreatedInstance(instance), callback);
    }
  }

  @VisibleForTesting
  void setApi(@NonNull CustomViewCallbackFlutterApi api) {
    this.api = api;
  }
}
