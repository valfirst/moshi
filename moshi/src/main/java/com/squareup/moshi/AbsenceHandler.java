/*
 * Copyright (C) 2021 Square, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.squareup.moshi;

import javax.annotation.Nullable;

/**
 * This interface is one that custom {@link JsonAdapter}s can implement to support handling absent
 * keys in JSON. They must indicate {@link #handlesAbsence()} to opt-in to handling, then implement
 * {@link #onAbsence} to actually handle the absence for a given key.
 */
public interface AbsenceHandler<T> {
  /** Returns whether or not this adapter handles absence. */
  boolean handlesAbsence();

  /**
   * Returns a nullable {@link T} instance for a given key. Should only be called if {@link
   * #handlesAbsence()} is true.
   */
  @Nullable
  default T onAbsence(String key) {
    throw new UnsupportedOperationException();
  }
}
