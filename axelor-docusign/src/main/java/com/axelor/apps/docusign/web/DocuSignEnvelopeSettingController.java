/*
 * Axelor Business Solutions
 *
 * Copyright (C) 2021 Axelor (<http://axelor.com>).
 *
 * This program is free software: you can redistribute it and/or  modify
 * it under the terms of the GNU Affero General Public License, version 3,
 * as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.axelor.apps.docusign.web;

import com.axelor.apps.docusign.service.DocuSignEnvelopeSettingService;
import com.axelor.exception.service.TraceBackService;
import com.axelor.inject.Beans;
import com.axelor.meta.db.MetaModel;
import com.axelor.meta.db.repo.MetaModelRepository;
import com.axelor.rpc.ActionRequest;
import com.axelor.rpc.ActionResponse;

public class DocuSignEnvelopeSettingController {

  public void addItemToReferenceSelection(ActionRequest request, ActionResponse response) {
    try {
      MetaModel metaModel = (MetaModel) request.getContext().get("metaModel");
      if (metaModel == null) {
        return;
      }

      metaModel = Beans.get(MetaModelRepository.class).find(metaModel.getId());
      Beans.get(DocuSignEnvelopeSettingService.class).addItemToReferenceSelection(metaModel);
    } catch (Exception e) {
      TraceBackService.trace(response, e);
    }
  }
}
