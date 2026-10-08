## Phase 1 Instance B - Issue-Ready Pack for P1-05 and P1-06 (v1)

Status: Publish pass complete
Version: 1.2
Last Updated: 2026-10-08
Source backlog: [phase1_sprint-planning_backlog.md](phase1_sprint-planning_backlog.md)

### Publication Checklist
- [x] Issue title format aligned to backlog mapping rules
- [x] Acceptance criteria are measurable and role-aligned
- [x] Evidence placeholders included
- [x] GitHub Project field values included
- [x] Explicit sign-off placeholders added for review and approval

---

## Issue 1

Title: [P1-05] Inventory applet touchpoints

### Summary
- Backlog ID: P1-05
- Sprint: Sprint 1A (Weeks 1-2)
- Owner Role: TL
- Story Points: 5
- Estimate Hours: 12

### Deliverable
- Catalog of Java applet dependencies with file-level references, including high-priority bridge classes and applet embedding hotspots.

### Dependencies
- P1-03

### Acceptance Criteria
1. Inventory identifies Java classes with applet runtime or JSObject bridge usage, including [software_development/src/org/adl/logging/LogManagerInterfaceApplet.java](../software_development/src/org/adl/logging/LogManagerInterfaceApplet.java) and related runtime drivers.
1. Inventory identifies top HTML embedding hotspots under [software_development/TestSuite](../software_development/TestSuite) and labels each by migration priority.
1. Inventory documents repeated embedding pattern families (MIME type, classid, MAYSCRIPT, IE/non-IE branch split).
1. Inventory includes an explicit replacement sequencing recommendation for modernization planning.
1. Inventory is reviewed by TL and J-LD and stored in planning artifacts.

### Execution Checklist
- [ ] Validate search command coverage for applet patterns.
- [ ] Confirm Java-side applet and JS bridge classes list.
- [ ] Confirm HTML embedding hotspot list and priorities.
- [ ] Add migration sequencing notes.
- [ ] Record review outcomes from TL + J-LD.

### Evidence
- Evidence Link(s):
- [P1-05 inventory document](phase1_p1-05_applet_touchpoints_inventory_v1.md)
- [P1-02 bootstrap evidence showing modern-JDK constraints context](phase1_p1-02_bootstrap_evidence_2026-10-08.md)
- Review sign-off note (to be added)

### Risks and Notes
- Risks: Applet embedding patterns are repeated across many package pages and may hide edge-case bridges.
- Notes: Use representative files for repeated course-resource templates to avoid redundant manual extraction.

### GitHub Project Field Values
- Item ID: P1-05
- Owner Role: TL
- Story Points: 5
- Estimate Hours: 12
- Remaining Hours: 12
- Blocked: No
- Dependency IDs: P1-03
- Target Sprint: Sprint 1A (Weeks 1-2)

### Sign-Off Placeholder
- Reviewer 1 (TL): Josephus Miller
- Reviewer 2 (J-LD): Naomi Nagata
- Review Date: <YYYY-MM-DD>
- Decision: <Approved | Approved with changes | Rework required>
- Follow-up Actions: <action items or None>
- Evidence of Approval: <link to comment, meeting note, or decision record>

---

## Issue 2

Title: [P1-06] Inventory frameset and legacy browser patterns

### Summary
- Backlog ID: P1-06
- Sprint: Sprint 1A (Weeks 1-2)
- Owner Role: W-LD
- Story Points: 5
- Estimate Hours: 12

### Deliverable
- Catalog of frameset, inline-handler, and browser-sniffing dependencies in [software_development/TestSuite](../software_development/TestSuite), including migration priority tags and representative file-level references.

### Dependencies
- P1-01

### Acceptance Criteria
1. Inventory identifies high-priority runtime frameset shells including [software_development/TestSuite/LMSRTE/LMSRTEMain.htm](../software_development/TestSuite/LMSRTE/LMSRTEMain.htm), [software_development/TestSuite/scoRTE/SCORTEMain.htm](../software_development/TestSuite/scoRTE/SCORTEMain.htm), [software_development/TestSuite/contentpackage/ContentPackageMain.htm](../software_development/TestSuite/contentpackage/ContentPackageMain.htm), and [software_development/TestSuite/contentpackage/ManifestUtilityMain.htm](../software_development/TestSuite/contentpackage/ManifestUtilityMain.htm).
1. Inventory documents inline event-handler concentration and identifies representative high-impact files.
1. Inventory documents browser-sniffing and compatibility logic, including [software_development/TestSuite/scripts/BrowserDetect.js](../software_development/TestSuite/scripts/BrowserDetect.js) and [software_development/TestSuite/scripts/EmulationCode.js](../software_development/TestSuite/scripts/EmulationCode.js).
1. Inventory provides a migration-priority order (entry surfaces, wrappers/utilities, then package/doc pages).
1. Inventory is reviewed by W-LD and QA and stored in planning artifacts.

### Execution Checklist
- [ ] Validate frameset shell list and wrapper list.
- [ ] Confirm inline-event hotspots with representative examples.
- [ ] Confirm browser-sniffing pattern sources.
- [ ] Confirm migration-priority ordering.
- [ ] Record review outcomes from W-LD + QA.

### Evidence
- Evidence Link(s):
- [P1-06 inventory document](phase1_p1-06_frameset_browser-pattern_inventory_v1.md)
- [P1-01 baseline matrix for runtime group mapping](phase1_p1-01_baseline_test_matrix_v1.md)
- Review sign-off note (to be added)

### Risks and Notes
- Risks: Legacy inline handlers may be generated or duplicated in course pages, causing undercount or overcount risk.
- Notes: Group repeated course resources by template to keep scope manageable while preserving migration confidence.

### GitHub Project Field Values
- Item ID: P1-06
- Owner Role: W-LD
- Story Points: 5
- Estimate Hours: 12
- Remaining Hours: 12
- Blocked: No
- Dependency IDs: P1-01
- Target Sprint: Sprint 1A (Weeks 1-2)

### Sign-Off Placeholder
- Reviewer 1 (W-LD): Alex Kamal
- Reviewer 2 (QA): James Holden
- Review Date: <YYYY-MM-DD>
- Decision: <Approved | Approved with changes | Rework required>
- Follow-up Actions: <action items or None>
- Evidence of Approval: <link to comment, meeting note, or decision record>

---

## Recommended Labels
- phase:1
- track:baseline
- area:inventory
- area:runtime-validation

## Version History
- v1.0 (2026-10-08): Initial issue-ready conversion for P1-05 and P1-06 with checklists, acceptance criteria, and field mappings.
- v1.1 (2026-10-08): Publish pass added with explicit sign-off placeholders and publication checklist.
- v1.2 (2026-10-08): Prefilled reviewer names in sign-off placeholders from role mapping.
