/*
 * Copyright (C) 2015 Romain Reuillon
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */


package org.openmole.plugin.task

import org.openmole.core.workflow.data._

package object gama {

  lazy val gamaInputs = new {
    def +=(p: Prototype[_]*) = (_: GamaTask.Builder).addGamaInput(p: _*)
    def +=(p: Prototype[_], name: String) = (_: GamaTask.Builder).addGamaInput(p, name)
  }

  lazy val gamaOutputs = new {
    def +=(name: String, prototype: Prototype[_]) = (_: GamaTask.Builder).addGamaOutput(name, prototype)
    def +=(prototype: Prototype[_]*) = (_: GamaTask.Builder).addGamaOutput(prototype: _*)
  }

  lazy val gamaVariableOutput = new {
    def +=(name: String, prototype: Prototype[_]) = (_: GamaTask.Builder).addGamaVariableOutput(name, prototype)
    def +=(prototype: Prototype[_]) = (_: GamaTask.Builder).addGamaVariableOutput(prototype)
  }

  lazy val gamaSeed = new {
    def :=(seed: Prototype[Long]) = (_: GamaTask.Builder).setSeed(seed)
  }

}
