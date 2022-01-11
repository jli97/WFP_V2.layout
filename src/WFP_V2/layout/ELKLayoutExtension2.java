package WFP_V2.layout;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.elk.core.service.LayoutMapping;
import org.eclipse.elk.graph.ElkNode;
import org.eclipse.elk.graph.properties.IProperty;
import org.eclipse.elk.graph.properties.Property;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.eclipse.sirius.diagram.elk.GmfLayoutCommand;
import org.eclipse.sirius.diagram.elk.IELKLayoutExtension;
import org.eclipse.sirius.diagram.ui.edit.api.part.AbstractDiagramNodeEditPart;
import org.eclipse.sirius.diagram.ui.internal.edit.parts.DNodeListEditPart;
import org.eclipse.elk.graph.ElkGraphElement;

public class ELKLayoutExtension2 implements IELKLayoutExtension {

	public ELKLayoutExtension2() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void beforeELKLayout(LayoutMapping layoutMapping) {
		// TODO Auto-generated constructor stub
		
		ArrayList<ElkNode> nodes = new ArrayList<>(layoutMapping.getLayoutGraph().getChildren());
		for (Entry<ElkGraphElement, Object> entry : layoutMapping.getGraphMap().entrySet()) {
		    Object editPart = entry.getValue();
		    //System.out.println(entry.getKey());
		    //System.out.println(entry.getValue().getClass());
		    
		    if (editPart instanceof DNodeListEditPart) {
		        EObject siriusDiagramElement = ((DNodeListEditPart) editPart).resolveTargetSemanticElement();
		        String elementName = siriusDiagramElement.eClass().getName();
		        IProperty<String> property = new Property("ObjectName");
		        entry.getKey().setProperty(property, elementName);
		        /*
		        if (siriusDiagramElement instanceof DDiagramElement) {
		        	EObject ecoreObj = ((DDiagramElement) siriusDiagramElement).getTarget();
		        	System.out.println("Got here");
		        	System.out.println(ecoreObj.getClass().getSimpleName());
		        }
		        System.out.println(siriusDiagramElement.getClass().getSimpleName());
		        */
		    }
		}
		
	}

	@Override
	public void afterELKLayout(LayoutMapping layoutMapping) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterGMFCommandApplied(GmfLayoutCommand gmfLayoutCommand, LayoutMapping layoutMapping) {
		// TODO Auto-generated method stub
		
	}

}
